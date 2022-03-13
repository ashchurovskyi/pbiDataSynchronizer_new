package com.barcom.pbiDataSynchronizer.schedulers;

import com.barcom.pbiDataSynchronizer.services.ReportShopStockService;
import com.barcom.pbiDataSynchronizer.utilities.CommonServiceUtility;
import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;

@Component
public class AutomaticStocksSynchronizing {


    ReportShopStockService reportShopStockService;

    public AutomaticStocksSynchronizing(ReportShopStockService reportShopStockService){
        this.reportShopStockService = reportShopStockService;
    }

    @Scheduled(cron = "${spring.cron.stocksSynchronizing.express}")
    public void synchronize(){

        Date date = new Date();
        String dateStr = DateUtility.convertDateToString(date);
        System.out.println("Synchronizing stocks "+dateStr);
        ArrayList<Integer> shopsIds = CommonServiceUtility.fillShopsIdIfEmpty(null,reportShopStockService.getQueryBuilder(),reportShopStockService.getExchangeDataSource());
        reportShopStockService.synchronizedStocksForDate(dateStr,shopsIds);

    }

}
