package com.nest.system_g_portal_backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nest.system_g_portal_backend.controller.StrykerDealerPortalController;
import com.nest.system_g_portal_backend.entities.StrykerDealerPortal;
import com.nest.system_g_portal_backend.service.StrykerDealerPortalService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@WebMvcTest(StrykerDealerPortalController.class)
public class StrykerDealerPortalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StrykerDealerPortalService strykerDealerPortalService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetSurgeryDetails() throws Exception {
        // Prepare the test data
        StrykerDealerPortal surgery1 = new StrykerDealerPortal();
        surgery1.setId(1);
        surgery1.setTicket_id(100);
        surgery1.setSurgery_name("Surgery 1");

        StrykerDealerPortal surgery2 = new StrykerDealerPortal();
        surgery2.setId(2);
        surgery2.setTicket_id(200);
        surgery2.setSurgery_name("Surgery 2");

        List<StrykerDealerPortal> surgeries = Arrays.asList(surgery1, surgery2);

        // Define the behavior of the mock service
        when(strykerDealerPortalService.getAllAvailableSurgeries()).thenReturn(surgeries);

        // Perform the GET request
        mockMvc.perform(MockMvcRequestBuilders.get("/viewallsurgeries"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ticket_id").value(100))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].surgery_name").value("Surgery 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ticket_id").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].surgery_name").value("Surgery 2"));

        // Verify the service method was called
        verify(strykerDealerPortalService, times(1)).getAllAvailableSurgeries();
    }

    @Test
    public void testUpdateStatus() throws Exception {
        // Prepare the test data
        StrykerDealerPortal surgery = new StrykerDealerPortal();
        surgery.setId(1);
        surgery.setStatus("Completed");

        // Define the behavior of the mock service
        when(strykerDealerPortalService.updateTicketStatus(any(StrykerDealerPortal.class))).thenReturn(surgery);

        // Perform the PUT request
        mockMvc.perform(MockMvcRequestBuilders.put("/updateticketstatus")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(surgery)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value("Completed"));

        // Verify the service method was called
        verify(strykerDealerPortalService, times(1)).updateTicketStatus(any(StrykerDealerPortal.class));
    }

    @Test
    public void testFilterDate() throws Exception {
        // Prepare the test data
        String date = "2023-05-25";
        StrykerDealerPortal surgery1 = new StrykerDealerPortal();
        surgery1.setId(1);
        surgery1.setTicket_id(100);
        surgery1.setSurgery_name("Surgery 1");

        StrykerDealerPortal surgery2 = new StrykerDealerPortal();
        surgery2.setId(2);
        surgery2.setTicket_id(200);
        surgery2.setSurgery_name("Surgery 2");

        List<StrykerDealerPortal> surgeries = Arrays.asList(surgery1, surgery2);

        // Define the behavior of the mock service
        when(strykerDealerPortalService.dateFilter(date)).thenReturn(surgeries);

        // Perform the GET request with path variable
        mockMvc.perform(MockMvcRequestBuilders.get("/dateFiler/{date}", date))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].ticket_id").value(100))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].surgery_name").value("Surgery 1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].ticket_id").value(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].surgery_name").value("Surgery 2"));

        // Verify the service method was called
        verify(strykerDealerPortalService, times(1)).dateFilter(date);
    }

    private static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

