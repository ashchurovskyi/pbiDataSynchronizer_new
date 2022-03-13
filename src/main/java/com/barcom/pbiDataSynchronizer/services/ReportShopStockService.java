package com.barcom.pbiDataSynchronizer.services;

import com.barcom.pbiDataSynchronizer.dto.ReportShopStocksDTO;
import com.barcom.pbiDataSynchronizer.entities.ReportShopStocks;
import com.barcom.pbiDataSynchronizer.factories.StocksQueryBuilder;
import com.barcom.pbiDataSynchronizer.repositories.ReportShopStockRepository;
import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ReportShopStockService  extends ApiService{

    private final ReportShopStockRepository repository;

    private final StocksQueryBuilder queryBuilder;

    public ReportShopStockService(ReportShopStockRepository repository, StocksQueryBuilder queryBuilder, JdbcTemplate exchangeDataSource){
        super(exchangeDataSource);
        this.repository = repository;
        this.queryBuilder = queryBuilder;
    }

    public ReportShopStockRepository getRepository() {
        return repository;
    }

    public StocksQueryBuilder getQueryBuilder() {
        return queryBuilder;
    }

    @Override
    public JdbcTemplate getExchangeDataSource() {
        return exchangeDataSource;
    }

    public ArrayList<ReportShopStocks> findAll(){
        return repository.findAll();
    }

    public int saveAll(ArrayList<ReportShopStocks> entityList){
       return  repository.saveAll(entityList).size();
    }

    public  boolean synchronizedStocksForDate(String stocksDate,ArrayList<Integer>shopsIds){
        int count =0;
        ExecutorService executorService = null;
        try {
            executorService = getExecutorService();
            LocalDateTime dateRes = DateUtility.convertStringToDate(stocksDate);
            clearDataForDateAndShops(dateRes,shopsIds);
            for (Integer shopId : shopsIds) {
                executorService.submit(synchronizedStocksForDateAsync(stocksDate,shopId));
                count +=1;
            }
        }catch (DataAccessException e){
            e.printStackTrace();
            count= -1;
        }finally {
            if(executorService!=null){
                executorService.shutdown();
                while (!executorService.isTerminated()){}
            }
        }
            return count >0;
    }

    private  Runnable synchronizedStocksForDateAsync(String stocksDate,Integer shopId){
        return ()->{ArrayList<ReportShopStocksDTO> sourceStocks = getStocksByDateFromSource(stocksDate,shopId);
        ArrayList<ReportShopStocks> reportShopStocks = convertToFinalEntity(sourceStocks);
        saveAll(reportShopStocks);};
    }

    public boolean clearDataForDateAndShops(LocalDateTime date, ArrayList<Integer> shopsIds){
        int count =0;
        try {
            repository.deleteByShopsIdsAndStockDate(shopsIds,date);
        }catch (DataAccessException e){
            e.printStackTrace();
            count= -1;
        }
        return count >0;
    }

    private ArrayList<ReportShopStocksDTO> getStocksByDateFromSource(String stocksDate, Integer shopId){
        String query = this.queryBuilder.getSelectQueryForShopAndDate(shopId,stocksDate);
        List<ReportShopStocksDTO> stocksList = this.exchangeDataSource.query(query, BeanPropertyRowMapper.newInstance(ReportShopStocksDTO.class));

        return (ArrayList<ReportShopStocksDTO>) stocksList;
    }

    private ArrayList<ReportShopStocks> convertToFinalEntity(ArrayList<ReportShopStocksDTO> sourceStocks){
        ArrayList<ReportShopStocks> result = new ArrayList<ReportShopStocks>();
        sourceStocks.forEach((sourceEntity->result.add(sourceEntity.convertToFinalEntity())));
        return result;
    }

}
