package com.barcom.pbiDataSynchronizer.factories;

import org.springframework.stereotype.Component;

@Component
public class StocksQueryBuilder implements QueryBuilderFactory {
    public StocksQueryBuilder() {
    }

    public String getShopsSelectQuery() {
        StringBuilder query = new StringBuilder();

        query.append("SELECT distinct(query.shopId) as shopID \n");
        query.append("FROM exchange.shop_good as query");

        return query.toString();
    }

    public String getSelectQueryForShopAndDate(Integer shopId, String stocksDate) {
        StringBuilder query = new StringBuilder();
        query.append("select \n");
        query.append("s.Id as shopId,\n");
        query.append("s.Address as shopDescription,\n");
        query.append("g.Article as goodArticle,\n");
        query.append("g.Name as goodDescription,\n");
        query.append("sg.Quantity as stockQuantity,\n");
        query.append("'");
        query.append(stocksDate);
        query.append("' as stockDate\n");
        query.append("from exchange.shop_good sg \n");
        query.append("inner join(\n");
        query.append("SELECT subquery.goodID,subquery.shopId, MAX(subquery.date) as date\n");
        query.append("FROM exchange.shop_good as subquery where subquery.shopId = ");
        query.append(shopId);
        query.append(" and subquery.date <= '");
        query.append(stocksDate);
        query.append("' group by goodID,shopId) as subquery\n");
        query.append("on sg.goodID = subquery.goodID and sg.shopId = subquery.shopId and sg.date = subquery.date\n");
        query.append("join shop s on sg.shopId = s.Id\n");
        query.append("join good g on sg.goodID = g.Id \n");
        query.append("where g.Article <>''\n");
        query.append("and g.good_market_id <> 0");
        return query.toString();
    }


}
