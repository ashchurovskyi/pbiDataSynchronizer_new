package com.barcom.pbiDataSynchronizer.controllers;

import com.barcom.pbiDataSynchronizer.services.ReportReceiptsService;
import com.barcom.pbiDataSynchronizer.utilities.ApiRequestParams;
import com.barcom.pbiDataSynchronizer.utilities.CommonServiceUtility;
import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Consumer;

@RestController
@RequestMapping("/api/java/receipts")
@Api("receipts")
public class ReceiptsController extends ApiController {

    private final ReportReceiptsService reportReceiptsService;

    public ReceiptsController(ReportReceiptsService reportReceiptsService){
        super();
        this.reportReceiptsService = reportReceiptsService;
    }

    @PostMapping("/receiptsForDates")
    public ResponseEntity<String> synchronizingReceiptsForDate(@RequestBody ApiRequestParams params){
        Runnable exec = ()->synchronizingReceiptsForDateAsync(params);
        return runAsync(exec);
    }


    @DeleteMapping("/clearData")
    public ResponseEntity<String> clearReceiptsData(@RequestBody ApiRequestParams params){
        Runnable exec = ()->clearDataForDatesAsync(params);
        return runAsync(exec);
    }


    private void synchronizingReceiptsForDateAsync(ApiRequestParams params){
        currentOperation = "Synchronizing receipts";
        Consumer<ApiRequestParams> executor = getSynchronizeExecutor(params,reportReceiptsService,0);
        executeAsync(executor,params);
    }

    private void clearDataForDatesAsync(ApiRequestParams params){
        currentOperation = "Clear receipts";
        Consumer<ApiRequestParams> executor = getClearDataExecutor(params,reportReceiptsService,0);
        executeAsync(executor,params);
    }

}
