package com.nest.system_g_portal_backend.controller;

import com.nest.system_g_portal_backend.entities.StrykerDealerPortal;
import com.nest.system_g_portal_backend.service.StrykerDealerPortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class StrykerDealerPortalController {

    @Autowired
    private StrykerDealerPortalService strykerDealerPortalService;



    @CrossOrigin(origins = "*")
    @GetMapping("/viewallsurgeries")
    public List<StrykerDealerPortal> getSurgeryDetails() {
        return strykerDealerPortalService.getAllAvailableSurgeries();
    }


    @CrossOrigin(origins = "*")
    @PutMapping("/updateticketstatus")
    public StrykerDealerPortal updateStatus(@RequestBody StrykerDealerPortal strykerDealerPortal){

        System.out.println(strykerDealerPortal.getId());
        System.out.println(strykerDealerPortal.getStatus());
        return strykerDealerPortalService.updateTicketStatus(strykerDealerPortal);
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/dateFiler/{date}")
    public  List<StrykerDealerPortal> filterDate(@PathVariable(value="date") String date ){
        System.out.println(date);
        return  strykerDealerPortalService.dateFilter(date);
    }


}
