package com.barcom.pbiDataSynchronizer.utilities;

import com.barcom.pbiDataSynchronizer.factories.QueryBuilderFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CommonServiceUtility {

    public static ArrayList<Integer> fillShopsIdIfEmpty(ArrayList<Integer> shopIds, QueryBuilderFactory queryFactory, JdbcTemplate exchangeDataSource){
        if(shopIds==null || shopIds.isEmpty()){
            String query = queryFactory.getShopsSelectQuery();
            shopIds = getShopsForSynchronizing(query, exchangeDataSource);
        }
        return shopIds;
    }

    public static ArrayList<Integer> fillShopsIdIfEmpty(ArrayList<Integer> shopIds, QueryBuilderFactory queryFactory, JdbcTemplate exchangeDataSource, LocalDateTime startDate, LocalDateTime endDate){
        if(shopIds==null || shopIds.isEmpty()){
            String query = queryFactory.getShopsSelectQuery(startDate,endDate);
            shopIds = getShopsForSynchronizing(query, exchangeDataSource);
        }
        return shopIds;

    }

    private static ArrayList<Integer> getShopsForSynchronizing(String query, JdbcTemplate exchangeDataSource) {
        ArrayList<Integer> res;
        res= (ArrayList<Integer>) exchangeDataSource.queryForList(query, Integer.class);
        return res;
    }

}
