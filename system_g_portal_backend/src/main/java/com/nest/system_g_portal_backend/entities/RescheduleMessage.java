package com.nest.system_g_portal_backend.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reschedule_message")

public class RescheduleMessage {

    @Id
    @GeneratedValue

    private int id;
    private int ticket_id;
    private String message;

    public RescheduleMessage() {
    }

    public RescheduleMessage(int id, int ticket_id, String message) {
        this.id = id;
        this.ticket_id = ticket_id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
