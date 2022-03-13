package com.barcom.pbiDataSynchronizer.services;

import com.barcom.pbiDataSynchronizer.dto.IncomesToShopDTO;
import com.barcom.pbiDataSynchronizer.dto.PassShiftGeneralDTO;
import com.barcom.pbiDataSynchronizer.dto.ReturnsFromShopDTO;
import com.barcom.pbiDataSynchronizer.dto.StocksInShopDTO;
import com.barcom.pbiDataSynchronizer.entities.ReportPassShift;
import com.barcom.pbiDataSynchronizer.factories.PassShiftFactory;
import com.barcom.pbiDataSynchronizer.factories.PassShiftQueryBuilder;
import com.barcom.pbiDataSynchronizer.repositories.ReportPassShiftRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

@Service
public class ReportPassShiftService extends ApiService{

    private final ReportPassShiftRepository repository;

    private final PassShiftQueryBuilder queryBuilder;

    private final PassShiftFactory shiftFactory;

    protected ReportPassShiftService( ReportPassShiftRepository repository, PassShiftQueryBuilder queryBuilder,JdbcTemplate exchangeDataSource,PassShiftFactory shiftFactory) {
        super(exchangeDataSource);
        this.shiftFactory = shiftFactory;
        this.repository = repository;
        this.queryBuilder = queryBuilder;
    }

    public ReportPassShiftRepository getRepository() {
        return repository;
    }

    @Override
    public PassShiftQueryBuilder getQueryBuilder() {
        return queryBuilder;
    }

    public Runnable getSynchronizePassShiftsForDatesAndShopExecutor(LocalDateTime startDate,LocalDateTime endDate,int shopId){
        return ()->{ArrayList<ReportPassShift> passShifts =getPassShiftsForDatesAndShop(startDate,endDate,shopId);
            repository.saveAll(passShifts);
        };
    }

    //Function was written by legacy code Dmytra M.
    private ArrayList<ReportPassShift> getPassShiftsForDatesAndShop(LocalDateTime startDate,LocalDateTime endDate,int shopId){

        List<ReportPassShift> shiftList = new ArrayList();
        List<PassShiftGeneralDTO> generalDataList = this.getGeneralPassShiftData(startDate, endDate, shopId);
        HashMap<String, HashMap<String, Double>> incomesMap = this.getIncomesToShopMap(startDate, endDate, shopId);
        HashMap<String, Double> returnsMap = this.getReturnsFromShopMap(startDate, endDate, shopId);
        HashMap<String, Double> stocksMap = this.getStocksMap(startDate, shopId);
        Iterator var13 = generalDataList.iterator();

        while(var13.hasNext()) {
            PassShiftGeneralDTO generalShiftData = (PassShiftGeneralDTO)var13.next();
            ReportPassShift shift = this.shiftFactory.createPassShiftObject(generalShiftData, incomesMap, returnsMap, startDate, endDate, stocksMap);
            shiftList.add(shift);
        }
        return (ArrayList)shiftList;
    }

    @Override
    public boolean synchronizeForDateAndShops(LocalDateTime startDate, LocalDateTime endDate, ArrayList<Integer> shopsIds) {
        int count =0;
        ExecutorService executorService = null;
        try {
            clearDataForDateAndShops(startDate,endDate,shopsIds);
            executorService = getExecutorService();
            for (Integer shopId : shopsIds) {
                executorService.execute(getSynchronizePassShiftsForDatesAndShopExecutor(startDate,endDate,shopId));
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

    @Override
    public boolean clearDataForDateAndShops(LocalDateTime startDate, LocalDateTime endDate, ArrayList<Integer> shopsIds){
        int count =0;
        try {
            repository.deleteByShopsIdsAndDates(shopsIds,startDate,endDate);
        }catch (DataAccessException e){
            e.printStackTrace();
            count= -1;
        }
        return count >0;
    }

//====================LEGACY FUNCTION FROM Dmytro======================

    private List<PassShiftGeneralDTO> getGeneralPassShiftData(LocalDateTime startDate, LocalDateTime endDate, int shopId) {
        String sql = this.queryBuilder.buildQueryForSelectGeneralPassShiftData(startDate, endDate, shopId);
        return this.exchangeDataSource.query(sql, BeanPropertyRowMapper.newInstance(PassShiftGeneralDTO.class));
    }

    private List<IncomesToShopDTO> getIncomesList(LocalDateTime startDate, LocalDateTime endDate, int shopId) {
        String sql = this.queryBuilder.buildSelectIncomesToShopQuery(startDate, endDate, shopId);
        return this.exchangeDataSource.query(sql, BeanPropertyRowMapper.newInstance(IncomesToShopDTO.class));
    }

    private HashMap<String, HashMap<String, Double>> getIncomesToShopMap(LocalDateTime startDate, LocalDateTime endDate, int shopId) {
        List<IncomesToShopDTO> incomesList = this.getIncomesList(startDate, endDate, shopId);
        HashMap<String, HashMap<String, Double>> incomesMap = new HashMap();
        Iterator var6 = incomesList.iterator();

        while(var6.hasNext()) {
            IncomesToShopDTO income = (IncomesToShopDTO)var6.next();
            String mapKey = income.getShop_id().toString() + "_" + income.getGood_id().toString();
            HashMap<String, Double> mapValue = new HashMap();
            mapValue.put("quantity", income.getQuantity());
            mapValue.put("checked_quantity", income.getChecked_quantity());
            incomesMap.put(mapKey, mapValue);
        }

        return incomesMap;
    }

    private List<ReturnsFromShopDTO> getReturnsList(LocalDateTime startDate, LocalDateTime endDate, int shopId) {
        String sql = this.queryBuilder.buildSelectReturnsFromShopQuery(startDate, endDate, shopId);
        return this.exchangeDataSource.query(sql, BeanPropertyRowMapper.newInstance(ReturnsFromShopDTO.class));
    }

    private HashMap<String, Double> getReturnsFromShopMap(LocalDateTime startDate, LocalDateTime endDate, int shopId) {
        List<ReturnsFromShopDTO> returnsList = this.getReturnsList(startDate, endDate, shopId);
        HashMap<String, Double> returnsMap = new HashMap();
        Iterator var6 = returnsList.iterator();

        while(var6.hasNext()) {
            ReturnsFromShopDTO returnData = (ReturnsFromShopDTO)var6.next();
            String mapKey = returnData.getShop_id() + "_" + returnData.getGood_id();
            returnsMap.put(mapKey, returnData.getReturn_quantity());
        }

        return returnsMap;
    }

    private List<StocksInShopDTO> getStocksInShopList(LocalDateTime stockDate, int shopId) {
        String sql = this.queryBuilder.buildSelectStocksInShop(stockDate, shopId);
        return this.exchangeDataSource.query(sql, BeanPropertyRowMapper.newInstance(StocksInShopDTO.class));
    }

    private HashMap<String, Double> getStocksMap(LocalDateTime stockDate, int shopId) {
        List<StocksInShopDTO> stocksList = this.getStocksInShopList(stockDate, shopId);
        HashMap<String, Double> stocksMap = new HashMap();
        Iterator var5 = stocksList.iterator();

        while(var5.hasNext()) {
            StocksInShopDTO stockData = (StocksInShopDTO)var5.next();
            String mapKey = stockData.getShop_id() + "_" + stockData.getGood_id();
            stocksMap.put(mapKey, stockData.getStock_quantity());
        }

        return stocksMap;
    }
}
