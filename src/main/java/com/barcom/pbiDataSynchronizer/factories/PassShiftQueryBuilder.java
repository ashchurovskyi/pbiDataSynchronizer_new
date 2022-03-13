package com.barcom.pbiDataSynchronizer.factories;

import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PassShiftQueryBuilder implements QueryBuilderFactory{

    public PassShiftQueryBuilder() {
    }

    public String buildQueryForSelectGeneralPassShiftData(LocalDateTime startDate, LocalDateTime endDate, int shopId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT \n");
        query.append("ps.ShopId as shop_id,\n");
        query.append("s.Address as shop_desc,\n");
        query.append("ps.date as creation_date,\n");
        query.append("ps.dateAccept as accept_date,\n");
        query.append("ps.accept as is_accepted,\n");
        query.append("g.Article as good_article,\n");
        query.append("g.Id as good_id,\n");
        query.append("g.Name as good_name,\n");
        query.append("g.Units as good_units,\n");
        query.append("psg.price as good_price,\n");
        query.append("psg.quantity_start as quantity_start,\n");
        query.append("psg.quantity_finish as quantity_finish,\n");
        query.append("psg.quantity_finish - psg.quantity_start as deviation_quantity\n");
        query.append("FROM pass_shift ps\n");
        query.append("JOIN pass_shift_goods psg ON (ps.id = psg.passShiftId AND ps.ShopId = psg.shopId)\n");
        query.append("JOIN good g ON (psg.goodId = g.Id)\n");
        query.append("JOIN shop s ON (ps.ShopId = s.Id)\n");
        query.append("WHERE ps.date BETWEEN ");
        query.append(DateUtility.convertDateToStringWithQuotes(startDate));
        query.append(" AND ");
        query.append(DateUtility.convertDateToStringWithQuotes(endDate));
        query.append("\n");
        query.append("AND ps.ShopId = ");
        query.append(shopId);
        query.append("\n");
        query.append("AND g.Article <> ''\n");
        return query.toString();
    }

    public String buildSelectIncomesToShopQuery(LocalDateTime startDate, LocalDateTime endDate, int shopId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT \n");
        query.append("delivery_goods.goodId as good_id,\n");
        query.append("delivery.shopId as shop_id,\n");
        query.append("sum(delivery_goods.quantity) as quantity,\n");
        query.append("sum(delivery_goods.checked_quantity) as checked_quantity\n");
        query.append("FROM delivery\n");
        query.append("JOIN delivery_goods ON (delivery.shopId = delivery_goods.shopID AND delivery.id = delivery_goods.deliveryId)\n");
        query.append("WHERE delivery.date BETWEEN ");
        query.append(DateUtility.convertDateToStringWithQuotes(startDate));
        query.append(" AND ");
        query.append(DateUtility.convertDateToStringWithQuotes(endDate));
        query.append("\n");
        query.append("AND delivery.shopId = ");
        query.append(shopId);
        query.append("\n");
        query.append("AND NOT delivery.IsMark \n");
        query.append("GROUP BY good_id,shop_id\n");
        return query.toString();
    }

    public String buildSelectReturnsFromShopQuery(LocalDateTime startDate, LocalDateTime endDate, int shopId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT \n");
        query.append("invoice_goods.goodid as good_id,\n");
        query.append("invoice.ShopId as shop_id,\n");
        query.append("sum(invoice_goods.quantity) as return_quantity\n");
        query.append("FROM invoice\n");
        query.append("JOIN invoice_goods ON (invoice.ShopId = invoice_goods.shopId AND invoice.Id = invoice_goods.invoiceid)\n");
        query.append("WHERE invoice.Date BETWEEN ");
        query.append(DateUtility.convertDateToStringWithQuotes(startDate));
        query.append(" AND ");
        query.append(DateUtility.convertDateToStringWithQuotes(endDate));
        query.append("\n");
        query.append("AND invoice.onecType = 2 \n");
        query.append("AND invoice.ShopId = ");
        query.append(shopId);
        query.append("\n");
        query.append("group by good_id,shop_id\n");
        return query.toString();
    }

    public String buildSelectStocksInShop(LocalDateTime stockDate, int shopId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT \n");
        query.append("sg.shopId as shop_id,\n");
        query.append("sg.goodID as good_id,\n");
        query.append("sg.Quantity as stock_quantity\n");
        query.append("FROM exchange.shop_good sg \n");
        query.append("INNER JOIN(\n");
        query.append("SELECT subquery.goodID,subquery.shopId, MAX(subquery.date) as date\n");
        query.append("FROM exchange.shop_good as subquery WHERE subquery.date <= ");
        query.append(DateUtility.convertDateToStringWithQuotes(stockDate));
        query.append(" AND subquery.shopId = ");
        query.append(shopId);
        query.append(" GROUP BY goodID,shopId) as subquery\n");
        query.append("ON sg.goodID = subquery.goodID AND sg.shopId = subquery.shopId AND sg.date = subquery.date\n");
        return query.toString();
    }

    public String buildClearAllQueryText() {
        return "TRUNCATE TABLE report_pass_shift RESTART IDENTITY";
    }

    public String buildClearForShopQuery(String shopId) {
        return "DELETE FROM report_pass_shift where shop_id = " + shopId;
    }

    public String buildClearForPeriodQuery(String startDate, String endDate) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM report_pass_shift WHERE creation_date BETWEEN '");
        query.append(startDate);
        query.append("' AND '");
        query.append(endDate);
        query.append("'");
        return query.toString();
    }

    public String buildClearForShopAndPeriodQuery(String shopId, String startDate, String endDate) {
        StringBuilder query = new StringBuilder();
        query.append("DELETE FROM report_pass_shift WHERE creation_date BETWEEN '");
        query.append(startDate);
        query.append("' AND '");
        query.append(endDate);
        query.append("'\n");
        query.append("AND shop_id = ");
        query.append(shopId);
        return query.toString();
    }

    public String buildSelectPassShiftsForPeriodAndShopId(String startDate, String endDate, String shopId) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT \n");
        query.append("*\n");
        query.append("FROM report_pass_shift\n");
        query.append("WHERE shop_id = ");
        query.append(shopId);
        query.append("\n");
        query.append("AND creation_date between '");
        query.append(startDate);
        query.append("' AND '");
        query.append(endDate);
        query.append("'\n");
        return query.toString();
    }


    @Override
    public String getShopsSelectQuery(LocalDateTime startDate, LocalDateTime endDate) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT DISTINCT ps.ShopId FROM pass_shift ps WHERE ps.date BETWEEN ");
        query.append(DateUtility.convertDateToStringWithQuotes(startDate));
        query.append(" AND ");
        query.append(DateUtility.convertDateToStringWithQuotes(endDate));
        query.append("");
        return query.toString();
    }


}
