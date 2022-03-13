package com.barcom.pbiDataSynchronizer.repositories;

import com.barcom.pbiDataSynchronizer.entities.ReportShopStocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface ReportShopStockRepository extends JpaRepository<ReportShopStocks,Integer> {

    ArrayList<ReportShopStocks> findAll();

    @Override
    <S extends ReportShopStocks> List<S> saveAll(Iterable<S> entities);

    @Transactional
    @Modifying
    @Query("delete from ReportShopStocks s where s.stockDate=:date and s.shopId in :shopsIds")
    void deleteByShopsIdsAndStockDate(@Param("shopsIds") ArrayList<Integer> shopsIds, @Param("date") LocalDateTime stockDate);
}
