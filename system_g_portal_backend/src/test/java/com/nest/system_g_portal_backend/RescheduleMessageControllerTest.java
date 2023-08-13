package com.nest.system_g_portal_backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nest.system_g_portal_backend.controller.RescheduleMessageController;
import com.nest.system_g_portal_backend.entities.RescheduleMessage;
import com.nest.system_g_portal_backend.service.RescheduleMessageService;
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

@WebMvcTest(RescheduleMessageController.class)
public class RescheduleMessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RescheduleMessageService rescheduleMessageService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddMessage() throws Exception {
        // Prepare the test data
        RescheduleMessage rescheduleMessage = new RescheduleMessage();
        rescheduleMessage.setId(1);
        rescheduleMessage.setTicket_id(100);
        rescheduleMessage.setMessage("Test message");

        // Define the behavior of the mock service
        when(rescheduleMessageService.addRescheduleMessage(any(RescheduleMessage.class))).thenReturn(rescheduleMessage);

        // Perform the POST request
        mockMvc.perform(MockMvcRequestBuilders.post("/addMessage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(rescheduleMessage)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ticket_id").value(100))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Test message"));

        // Verify the service method was called
        verify(rescheduleMessageService, times(1)).addRescheduleMessage(any(RescheduleMessage.class));
    }

    private static String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

