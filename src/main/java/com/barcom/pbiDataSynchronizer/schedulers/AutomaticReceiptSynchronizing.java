package com.barcom.pbiDataSynchronizer.schedulers;

import com.barcom.pbiDataSynchronizer.services.ReportReceiptsService;
import com.barcom.pbiDataSynchronizer.utilities.CommonServiceUtility;
import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;

@Component
public class AutomaticReceiptSynchronizing {

    private ReportReceiptsService reportReceiptsService;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public AutomaticReceiptSynchronizing(ReportReceiptsService reportReceiptsService){
        this.reportReceiptsService = reportReceiptsService;
    }

    @Scheduled(cron = "${spring.cron.receiptsSynchronizing.express}")
    public void synchronize(){

        fillPeriod();
        ArrayList<Integer> shopsIds = CommonServiceUtility.fillShopsIdIfEmpty(null,reportReceiptsService.getQueryBuilder()
                ,reportReceiptsService.getExchangeDataSource()
                    ,this.startDate,this.endDate);

        System.out.println("Synchronizing receipts "+startDate);
        reportReceiptsService.synchronizeForDateAndShops(this.startDate,this.endDate,shopsIds);

    }

    private void fillPeriod(){
        this.startDate = DateUtility.getStartOfDay(LocalDateTime.now().minusMonths(1).with(TemporalAdjusters.firstDayOfMonth()));
        this.endDate = DateUtility.getEndOfDay(startDate.with(TemporalAdjusters.lastDayOfMonth()));

    }

}
