package com.barcom.pbiDataSynchronizer.repositories;

import com.barcom.pbiDataSynchronizer.entities.ReportPassShift;
import com.barcom.pbiDataSynchronizer.entities.ReportShopStocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface ReportPassShiftRepository extends JpaRepository<ReportPassShift,Integer> {

    ArrayList<ReportPassShift> findAll();

    @Override
    <S extends ReportPassShift> List<S> saveAll(Iterable<S> entities);

    @Transactional
    @Modifying
    @Query("delete from ReportPassShift s where s.creationDate between :startDate and :endDate and s.shopId in :shopsIds")
    void deleteByShopsIdsAndDates(@Param("shopsIds") ArrayList<Integer> shopsIds, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
