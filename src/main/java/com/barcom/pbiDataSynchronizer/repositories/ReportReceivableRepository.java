package com.barcom.pbiDataSynchronizer.repositories;

import com.barcom.pbiDataSynchronizer.entities.ReportReceivable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface ReportReceivableRepository extends JpaRepository<ReportReceivable,Integer> {

    @Override
    <S extends ReportReceivable> List<S> saveAll(Iterable<S> entities);

    @Transactional
    @Modifying
    @Query("delete from ReportReceivable s where s.settlementDate between :startDate and :endDate ")
    void deleteByDate(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
