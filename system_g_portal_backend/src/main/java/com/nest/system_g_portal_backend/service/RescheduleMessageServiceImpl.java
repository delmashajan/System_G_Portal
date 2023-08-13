package com.nest.system_g_portal_backend.service;

import com.nest.system_g_portal_backend.entities.RescheduleMessage;
import com.nest.system_g_portal_backend.repository.RescheduleMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RescheduleMessageServiceImpl implements RescheduleMessageService{

    @Autowired
    private RescheduleMessageRepo rescheduleMessageRepo;


    @Override
    public RescheduleMessage addRescheduleMessage(RescheduleMessage rescheduleMessage){

        return rescheduleMessageRepo.save(rescheduleMessage);

    }
}
