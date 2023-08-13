package com.nest.system_g_portal_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "stryker_dealer_portal")

public class StrykerDealerPortal {
    @Id
    @GeneratedValue
    private int id;
    private int ticket_id;
    private String surgery_name;
    private String date;
    private String priority;
    private String status;
    private String order_item_count;
    private String assigned_agent;
    private String time;

    public StrykerDealerPortal() {
    }

    public StrykerDealerPortal(int id, int ticket_id, String surgery_name, String date, String priority, String status, String order_item_count, String assigned_agent, String time) {
        this.id = id;
        this.ticket_id = ticket_id;
        this.surgery_name = surgery_name;
        this.date = date;
        this.priority = priority;
        this.status = status;
        this.order_item_count = order_item_count;
        this.assigned_agent = assigned_agent;
        this.time = time;
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

    public String getSurgery_name() {
        return surgery_name;
    }

    public void setSurgery_name(String surgery_name) {
        this.surgery_name = surgery_name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrder_item_count() {
        return order_item_count;
    }

    public void setOrder_item_count(String order_item_count) {
        this.order_item_count = order_item_count;
    }

    public String getAssigned_agent() {
        return assigned_agent;
    }

    public void setAssigned_agent(String assigned_agent) {
        this.assigned_agent = assigned_agent;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
