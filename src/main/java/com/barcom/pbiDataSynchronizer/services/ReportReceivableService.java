package com.barcom.pbiDataSynchronizer.services;

import com.barcom.pbiDataSynchronizer.entities.ReportReceivable;
import com.barcom.pbiDataSynchronizer.factories.QueryBuilderFactory;
import com.barcom.pbiDataSynchronizer.repositories.ReportReceivableRepository;
import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ReportReceivableService{

    private ReportReceivableRepository repository;

    public ReportReceivableService(ReportReceivableRepository repository){
        this.repository = repository;
    }

    public int saveAll(List<ReportReceivable> list){
       return repository.saveAll(list).size();
    }

    public void clearByDate(LocalDateTime date){

        repository.deleteByDate(DateUtility.getStartOfDay(date), DateUtility.getEndOfDay(date));

    }

}
