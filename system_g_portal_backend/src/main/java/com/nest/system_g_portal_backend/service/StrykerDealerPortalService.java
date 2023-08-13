package com.nest.system_g_portal_backend.service;

import com.nest.system_g_portal_backend.entities.StrykerDealerPortal;

import java.util.List;

public interface StrykerDealerPortalService {

    public List<StrykerDealerPortal> getAllAvailableSurgeries();

    public StrykerDealerPortal updateTicketStatus(StrykerDealerPortal strykerDealerPortal);

    public List<StrykerDealerPortal> dateFilter(String date);
}
