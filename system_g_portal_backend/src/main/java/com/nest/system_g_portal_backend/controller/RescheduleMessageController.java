package com.nest.system_g_portal_backend.controller;

import com.nest.system_g_portal_backend.entities.RescheduleMessage;
import com.nest.system_g_portal_backend.service.RescheduleMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class RescheduleMessageController {

    @Autowired
    private RescheduleMessageService rescheduleMessageService;

    @CrossOrigin(value = "*")
    @PostMapping("/addMessage")
    public RescheduleMessage addMessage(@RequestBody RescheduleMessage rescheduleMessage){
        return rescheduleMessageService.addRescheduleMessage(rescheduleMessage);
    }

}
