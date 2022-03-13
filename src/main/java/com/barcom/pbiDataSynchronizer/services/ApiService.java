package com.barcom.pbiDataSynchronizer.services;

import com.barcom.pbiDataSynchronizer.factories.QueryBuilderFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class   ApiService {

    @Qualifier("jdbcTemplate2")
    protected final JdbcTemplate exchangeDataSource;

    protected ApiService(JdbcTemplate exchangeDataSource) {
        this.exchangeDataSource = exchangeDataSource;
    }

    protected ExecutorService getExecutorService(){
        return Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    }

    public JdbcTemplate getExchangeDataSource() {
        return exchangeDataSource;
    }

    public abstract QueryBuilderFactory getQueryBuilder();

    public boolean synchronizeForDateAndShops(LocalDateTime startDate, LocalDateTime endDate, ArrayList<Integer> shopsIds){
        return false;
    };

    public boolean clearDataForDateAndShops(LocalDateTime startDate, LocalDateTime endDate, ArrayList<Integer> shopsIds){
        return false;
    };
}
