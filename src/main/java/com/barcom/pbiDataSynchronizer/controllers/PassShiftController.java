package com.barcom.pbiDataSynchronizer.controllers;

import com.barcom.pbiDataSynchronizer.services.ReportPassShiftService;
import com.barcom.pbiDataSynchronizer.utilities.ApiRequestParams;
import com.barcom.pbiDataSynchronizer.utilities.CommonServiceUtility;
import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.apache.tomcat.jni.Local;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.function.Consumer;

@RestController
@RequestMapping("/api/java/passShifts")
@Api("passShifts")
public class PassShiftController extends ApiController{

    private final ReportPassShiftService reportPassShiftService;

    public PassShiftController( ReportPassShiftService reportPassShiftService){
        super();
        this.reportPassShiftService = reportPassShiftService;
    }

    @PostMapping("/passShiftsForDates")
    public ResponseEntity<String> synchronizePassShifts(@RequestBody ApiRequestParams params){
        Runnable exec = ()->synchronizePassShiftsAsync(params);
        return runAsync(exec);

    }

    @DeleteMapping("/clearDate")
    public ResponseEntity<String>clearPassShiftsData(@RequestBody ApiRequestParams params){
        Runnable exec = ()->clearPassShiftsDataAsync(params);
        return runAsync(exec);
    }

    private void synchronizePassShiftsAsync(ApiRequestParams params){
        currentOperation = "Synchronizing pass shift";
        Consumer<ApiRequestParams> executor = getSynchronizeExecutor(params,reportPassShiftService,6);
        executeAsync(executor,params);


    }

    private void clearPassShiftsDataAsync(ApiRequestParams params){
        currentOperation = "Clear pass shift";
        Consumer<ApiRequestParams> executor = getClearDataExecutor(params,reportPassShiftService,6);
        executeAsync(executor,params);
    }


}
