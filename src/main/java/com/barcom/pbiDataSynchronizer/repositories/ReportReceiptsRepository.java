package com.barcom.pbiDataSynchronizer.repositories;

import com.barcom.pbiDataSynchronizer.entities.ReportReceipts;
import com.barcom.pbiDataSynchronizer.entities.ReportShopStocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public interface ReportReceiptsRepository extends JpaRepository<ReportReceipts,Integer> {

    ArrayList<ReportReceipts> findAll();

    @Override
    <S extends ReportReceipts> List<S> saveAll(Iterable<S> entities);

    @Transactional
    @Modifying
    @Query("delete from ReportReceipts s where s.check_date between :startDate and :endDate and s.shopId in :shopsIds")
    void deleteByShopsIdsAndDate(@Param("shopsIds") ArrayList<Integer> shopsIds, @Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
