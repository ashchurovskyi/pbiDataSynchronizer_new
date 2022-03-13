package com.barcom.pbiDataSynchronizer.schedulers;

import com.barcom.pbiDataSynchronizer.services.ReportPassShiftService;
import com.barcom.pbiDataSynchronizer.services.ReportReceiptsService;
import com.barcom.pbiDataSynchronizer.utilities.CommonServiceUtility;
import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.HashMap;

@Component
public class AutomaticPassShiftSynchronizing {

    private ReportPassShiftService reportPassShiftService;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public AutomaticPassShiftSynchronizing(ReportPassShiftService reportPassShiftService){
        this.reportPassShiftService = reportPassShiftService;
    }

    @Scheduled(cron = "${spring.cron.passShiftSynchronizing.express}")
    public void synchronize(){
        fillPeriod();

        ArrayList<Integer> shopsIds = CommonServiceUtility.fillShopsIdIfEmpty(null,reportPassShiftService.getQueryBuilder()
                ,reportPassShiftService.getExchangeDataSource()
                ,this.startDate,this.endDate);

        System.out.println("Synchronizing pass shifts "+startDate);
        reportPassShiftService.synchronizeForDateAndShops(this.startDate,this.endDate,shopsIds);
    }

    private void fillPeriod(){
        LocalDateTime date = LocalDateTime.now();
        this.startDate = DateUtility.getStartOfDay(date.minusDays(7));
        this.endDate = DateUtility.getEndOfDay(date.minusDays(1));
    }

}
