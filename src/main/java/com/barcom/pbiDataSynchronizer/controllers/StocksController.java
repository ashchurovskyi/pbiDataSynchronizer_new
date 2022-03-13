package com.barcom.pbiDataSynchronizer.controllers;

import com.barcom.pbiDataSynchronizer.services.ReportShopStockService;
import com.barcom.pbiDataSynchronizer.utilities.ApiResponseBody;
import com.barcom.pbiDataSynchronizer.utilities.CommonServiceUtility;
import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import com.barcom.pbiDataSynchronizer.utilities.ApiRequestParams;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Consumer;

@RestController
@RequestMapping("/api/java/stocks")
@Api("stocks")
public class StocksController extends ApiController  {

    private final Logger logger = LoggerFactory.getLogger(StocksController.class);

    private final ReportShopStockService reportShopStockService;

    static interface RequestParameterBody{}


    public StocksController(ReportShopStockService reportShopStockService) {
        super();
        this.reportShopStockService = reportShopStockService;
    }

    @PostMapping(value = "/stockForDates")
    public ResponseEntity<String> synchronizeStocksForDates(@RequestBody ApiRequestParams params){
        Runnable exec = ()->synchronizeStocksForDatesAsync(params);
        return runAsync(exec);
    }

    @DeleteMapping(value = "/clearData")
    public ResponseEntity<String>clearData(@RequestBody ApiRequestParams params){

        ApiResponseBody result = new ApiResponseBody();
        try {
            if(!isBlocked){
                clearDataForDatesAsync(params);
                result.setResponseBody(HttpStatus.OK,"Почалось видалення даних");
            }else {
                result.setResponseBody(HttpStatus.OK,"Виконується процес маніпуляції даних. Повторний запуск заборонено. Спробуйте пізніше.");
            }
        }catch (Exception e){
            result.setResponseBody(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }
        return new ResponseEntity(result.getDescription(),(MultiValueMap<String, String>) null, result.getStatus());
    }

    public void synchronizeStocksForDatesAsync(ApiRequestParams params){
        currentOperation = "Synchronizing stocks";
        Consumer<ApiRequestParams> executor = (parameters) ->{
            ArrayList<Integer> shopsIds = CommonServiceUtility.fillShopsIdIfEmpty(parameters.getShops(),reportShopStockService.getQueryBuilder(),reportShopStockService.getExchangeDataSource());
            parameters.getDates().forEach((date)->reportShopStockService.synchronizedStocksForDate(date,shopsIds));};
        executeAsync(executor,params);
    }

    public void clearDataForDatesAsync( ApiRequestParams params){
        currentOperation = "Clear stock";
        Consumer<ApiRequestParams> executor = (parameters) ->{
            ArrayList<Integer> shopsIds = CommonServiceUtility.fillShopsIdIfEmpty(parameters.getShops(),reportShopStockService.getQueryBuilder(),reportShopStockService.getExchangeDataSource());
            parameters.getDates().forEach((date)->{
                LocalDateTime dateRes = DateUtility.convertStringToDate(date);
                reportShopStockService.clearDataForDateAndShops(dateRes,shopsIds);
            });
        };


        executeAsync(executor,params);
    }





}
