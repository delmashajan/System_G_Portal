package com.nest.system_g_portal_backend.repository;

import com.nest.system_g_portal_backend.entities.StrykerDealerPortal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StrykerDealerPortalRepo extends JpaRepository<StrykerDealerPortal,Integer> {


    @Query(value = "SELECT `id`, `ticket_id`, `surgery_name`, `date`, `priority`, `status`, `assigned_agent`, `order_item_count`, `time` FROM `stryker_dealer_portal` WHERE `date`= :date",nativeQuery = true)
    List<StrykerDealerPortal> dateFilter(@Param("date") String date);


}
