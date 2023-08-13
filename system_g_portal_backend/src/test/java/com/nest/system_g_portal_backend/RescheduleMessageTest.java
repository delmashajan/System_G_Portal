package com.nest.system_g_portal_backend;

import com.nest.system_g_portal_backend.entities.RescheduleMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RescheduleMessageTest {

    @Test
    public void testGettersAndSetters() {
        // Create a RescheduleMessage object
        int id = 1;
        int ticketId = 100;
        String message = "Sample reschedule message";
        RescheduleMessage rescheduleMessage = new RescheduleMessage(id, ticketId, message);

        // Verify the values using getters
        Assertions.assertEquals(id, rescheduleMessage.getId());
        Assertions.assertEquals(ticketId, rescheduleMessage.getTicket_id());
        Assertions.assertEquals(message, rescheduleMessage.getMessage());

        // Update the values using setters
        int newId = 2;
        int newTicketId = 200;
        String newMessage = "Updated reschedule message";
        rescheduleMessage.setId(newId);
        rescheduleMessage.setTicket_id(newTicketId);
        rescheduleMessage.setMessage(newMessage);

        // Verify the updated values using getters
        Assertions.assertEquals(newId, rescheduleMessage.getId());
        Assertions.assertEquals(newTicketId, rescheduleMessage.getTicket_id());
        Assertions.assertEquals(newMessage, rescheduleMessage.getMessage());
    }
}

