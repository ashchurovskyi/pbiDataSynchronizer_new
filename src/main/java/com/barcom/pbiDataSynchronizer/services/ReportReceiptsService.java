package com.barcom.pbiDataSynchronizer.services;
import com.barcom.pbiDataSynchronizer.entities.ReportReceipts;
import com.barcom.pbiDataSynchronizer.factories.ReceiptsQueryBuilder;
import com.barcom.pbiDataSynchronizer.repositories.ReportReceiptsRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;


@Service
public class ReportReceiptsService extends ApiService {

    private ReportReceiptsRepository repository;

    private ReceiptsQueryBuilder queryBuilder;

    public ReportReceiptsService(ReportReceiptsRepository repository, ReceiptsQueryBuilder queryBuilder, JdbcTemplate exchangeDataSource){
        super(exchangeDataSource);
        this.repository = repository;
        this.queryBuilder  = queryBuilder;
    }

    public ReportReceiptsRepository getRepository() {
        return repository;
    }

    public ReceiptsQueryBuilder getQueryBuilder() {
        return queryBuilder;
    }

    @Override
    public JdbcTemplate getExchangeDataSource() {
        return exchangeDataSource;
    }

    public ArrayList<ReportReceipts> findAll(){
        return repository.findAll();
    }

    public int saveAll(ArrayList<ReportReceipts> entityList){
        return  repository.saveAll(entityList).size();
    }

    @Override
    public  boolean synchronizeForDateAndShops(LocalDateTime startDate,LocalDateTime endDate,ArrayList<Integer>shopsIds){
        int count =0;
        ExecutorService executorService = null;
        try {
           clearDataForDateAndShops(startDate,endDate,shopsIds);
            executorService = getExecutorService();
            for (Integer shopId : shopsIds) {
                executorService.execute(synchronizeReceiptsForDateAsync(startDate,endDate,shopId));
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

    private  Runnable synchronizeReceiptsForDateAsync(LocalDateTime startDate,LocalDateTime endDate ,int shopId){
        return ()->{ArrayList<ReportReceipts> sourceReceipt = getReceiptsByDateFromSource(startDate,endDate,shopId);
            saveAll(sourceReceipt);};
    }

    private ArrayList<ReportReceipts> getReceiptsByDateFromSource(LocalDateTime startDate,LocalDateTime endDate, int shopId){
        String query = this.queryBuilder.getSelectQueryForShopAndDate(shopId,startDate,endDate);
        List<ReportReceipts> stocksList = this.exchangeDataSource.query(query, BeanPropertyRowMapper.newInstance(ReportReceipts.class));
        return (ArrayList<ReportReceipts>) stocksList;
    }

    @Override
    public boolean clearDataForDateAndShops(LocalDateTime startDate,LocalDateTime endDate, ArrayList<Integer> shopsIds){
        int count =0;
        try {
            repository.deleteByShopsIdsAndDate(shopsIds,startDate,endDate);
        }catch (DataAccessException e){
            e.printStackTrace();
            count= -1;
        }
        return count >0;
    }


}
