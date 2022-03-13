package com.barcom.pbiDataSynchronizer.controllers;

import com.barcom.pbiDataSynchronizer.services.ApiService;
import com.barcom.pbiDataSynchronizer.utilities.ApiResponseBody;
import com.barcom.pbiDataSynchronizer.utilities.ApiRequestParams;
import com.barcom.pbiDataSynchronizer.utilities.CommonServiceUtility;
import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class ApiController {

    protected static boolean isBlocked;

    protected static String currentOperation;

    protected final Lock locker = new ReentrantLock();

    protected void runInNewThread(Runnable execFunction){
        new Thread(execFunction).start();
    }

    protected void executeAsync(Consumer<ApiRequestParams> executor, ApiRequestParams params){
        isBlocked = false;
        System.out.println("Start of "+currentOperation);
        ApiResponseBody result = new ApiResponseBody();
        try {
            isBlocked = locker.tryLock();
            if(isBlocked){
                 executor.accept(params);
                //new Thread(runner).start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(isBlocked){
                isBlocked = false;
                locker.unlock();
                System.out.println("End of "+currentOperation);
            };
        }
    }

    protected ResponseEntity<String> runAsync(Runnable exec){
        ApiResponseBody result = new ApiResponseBody();
        try {
            if(!isBlocked){
                runInNewThread(exec);
                result.setResponseBody(HttpStatus.OK,"Почалась обробка даних");
            }else {
                result.setResponseBody(HttpStatus.OK,"Виконується процес обробки даних. Повторний запуск заборонено. Спробуйте пізніше.");
            }
        }catch (Exception e){
            result.setResponseBody(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
        }

        return new ResponseEntity(result.getDescription(),(MultiValueMap<String, String>) null, result.getStatus());
    }

    protected Consumer<ApiRequestParams> getSynchronizeExecutor(ApiRequestParams params, ApiService apiService, int startDateShiftDays){
        Consumer<ApiRequestParams> executor = (parameters)->{
            Consumer<String> execByDate = (dateStr)->{
                LocalDateTime date = DateUtility.convertStringToDate(dateStr);
                LocalDateTime startDate = DateUtility.getStartOfDay(date).minusDays(startDateShiftDays);
                LocalDateTime endDate = DateUtility.getEndOfDay(date);
                ArrayList<Integer> shopsIds = CommonServiceUtility.fillShopsIdIfEmpty(parameters.getShops(),
                        apiService.getQueryBuilder(),
                            apiService.getExchangeDataSource(),startDate,endDate);
                                apiService.synchronizeForDateAndShops(startDate,endDate,shopsIds);
            };
            parameters.getDates().forEach(execByDate);
        };

        return executor;
    }

    protected Consumer<ApiRequestParams> getClearDataExecutor(ApiRequestParams params, ApiService apiService, int startDateShiftDays){
        Consumer<ApiRequestParams>  executor = (parameters)->parameters.getDates().forEach((dateStr)->{
            LocalDateTime date = DateUtility.convertStringToDate(dateStr);
            LocalDateTime startDate = DateUtility.getStartOfDay(date).minusDays(startDateShiftDays);
            LocalDateTime endDate = DateUtility.getEndOfDay(date);

            ArrayList<Integer> shopsIds = CommonServiceUtility.fillShopsIdIfEmpty(parameters.getShops(),
                    apiService.getQueryBuilder(),apiService.getExchangeDataSource(),
                    startDate,endDate);
            apiService.clearDataForDateAndShops(startDate,endDate,shopsIds);
        });
        return executor;
    }

}
