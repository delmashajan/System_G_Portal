package com.nest.system_g_portal_backend;

import com.nest.system_g_portal_backend.entities.StrykerDealerPortal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StrykerDealerPortalTest {

    @Test
    public void testGettersAndSetters() {
        // Create a StrykerDealerPortal object
        int id = 1;
        int ticketId = 100;
        String surgeryName = "Sample Surgery";
        String date = "2023-05-25";
        String priority = "High";
        String status = "Pending";
        String orderItemCount = "5";
        String assignedAgent = "John Doe";
        String time = "10:00 AM";

        StrykerDealerPortal portal = new StrykerDealerPortal(id, ticketId, surgeryName, date, priority, status, orderItemCount, assignedAgent, time);

        // Verify the values using getters
        Assertions.assertEquals(id, portal.getId());
        Assertions.assertEquals(ticketId, portal.getTicket_id());
        Assertions.assertEquals(surgeryName, portal.getSurgery_name());
        Assertions.assertEquals(date, portal.getDate());
        Assertions.assertEquals(priority, portal.getPriority());
        Assertions.assertEquals(status, portal.getStatus());
        Assertions.assertEquals(orderItemCount, portal.getOrder_item_count());
        Assertions.assertEquals(assignedAgent, portal.getAssigned_agent());
        Assertions.assertEquals(time, portal.getTime());

        // Update the values using setters
        int newId = 2;
        int newTicketId = 200;
        String newSurgeryName = "Updated Surgery";
        String newDate = "2023-05-26";
        String newPriority = "Low";
        String newStatus = "Completed";
        String newOrderItemCount = "10";
        String newAssignedAgent = "Jane Smith";
        String newTime = "2:00 PM";

        portal.setId(newId);
        portal.setTicket_id(newTicketId);
        portal.setSurgery_name(newSurgeryName);
        portal.setDate(newDate);
        portal.setPriority(newPriority);
        portal.setStatus(newStatus);
        portal.setOrder_item_count(newOrderItemCount);
        portal.setAssigned_agent(newAssignedAgent);
        portal.setTime(newTime);

        // Verify the updated values using getters
        Assertions.assertEquals(newId, portal.getId());
        Assertions.assertEquals(newTicketId, portal.getTicket_id());
        Assertions.assertEquals(newSurgeryName, portal.getSurgery_name());
        Assertions.assertEquals(newDate, portal.getDate());
        Assertions.assertEquals(newPriority, portal.getPriority());
        Assertions.assertEquals(newStatus, portal.getStatus());
        Assertions.assertEquals(newOrderItemCount, portal.getOrder_item_count());
        Assertions.assertEquals(newAssignedAgent, portal.getAssigned_agent());
        Assertions.assertEquals(newTime, portal.getTime());
    }
}

