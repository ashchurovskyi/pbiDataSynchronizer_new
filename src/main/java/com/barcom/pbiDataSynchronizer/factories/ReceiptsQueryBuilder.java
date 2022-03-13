//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.barcom.pbiDataSynchronizer.factories;

import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReceiptsQueryBuilder implements QueryBuilderFactory{
    public ReceiptsQueryBuilder() {
    }

    public String getSelectQueryForShopAndDate(int shopId,LocalDateTime startDate, LocalDateTime endDate) {
        StringBuilder query = new StringBuilder();
        query.append("SELECT \n");
        query.append("0 as amount,\n");
        query.append("0 as amount_without_discount,\n");
        query.append("case when  reciept_goods.last_position = 1  then reciept_goods.amount_discount - (reciept.discount_total - reciept.Total) else reciept_goods.amount_discount end as amount_loyal_balls,\n");
        query.append("0 - case when  reciept_goods.last_position = 1  then reciept_goods.amount_discount - (reciept.discount_total - reciept.Total) else reciept_goods.amount_discount end + 0 as sum_discont,\n");
        query.append("reciept.date as check_date,\n");
        query.append("reciept.shopId as shop_id,\n");
        query.append("reciept.Id as check_number, \n");
        query.append("case when sales = 0 then 'cash' when sales = 1 then 'refoun' when sales = 2 then 'card' when sales = 3 then 'online' end as payment_method,\n");
        query.append("reciept_goods.quantity as quantity,\n");
        query.append("case when sales = 1 then reciept_goods.quantity else 0 end as refound_quantity,\n");
        query.append("case when sales = 1 then case when discount_total <> 0 then discount_total else Total end else 0 end as feround_amount,\n");
        query.append("good_categories.name as good_category,\n");
        query.append("shop.address as shop_address,\n");
        query.append("category_shop.name as category_shop_name,\n");
        query.append("good.name as good_name,good.id as good_id,\n");
        query.append("good_market.name as good_market_desc,\n");
        query.append("good_family.name as good_family_desc,\n");
        query.append("good_category.name as good_category_desc,\n");
        query.append("good.article as good_article,\n");
        query.append("region.name as region_name,\n");
        query.append("good.units as unit\n");
        query.append("FROM reciept\n");
        query.append("join\n");
        query.append("reciept_goods on (reciept.id = reciept_goods.recieptId and reciept.shopId = reciept_goods.shopId)\n");
        query.append("join \n");
        query.append("good on reciept_goods.goodId = good.Id\n");
        query.append("join\n");
        query.append("shop on reciept.shopId = shop.Id\n");
        query.append("left join \n");
        query.append("good_categories on good.category_id = good_categories.id\n");
        query.append("left join region on shop.regionId = region.id\n");
        query.append("left join good_market on good.good_market_id = good_market.id\n");
        query.append("left join good_category on good.good_category_id = good_category.id\n");
        query.append("left join good_family on good.good_family_id = good_family.id\n");
        query.append("left join category_shop on shop.category_shop_id = category_shop.id\n");
        query.append("where reciept.date between "+DateUtility.convertDateToStringWithQuotes(startDate)+" and "+DateUtility.convertDateToStringWithQuotes(endDate));
        query.append("\n");
        query.append("and reciept.discountType = 10\n");
        query.append("and reciept.ShopID = ");
        query.append(shopId);
        query.append("\n");
        query.append("union all\n");
        query.append("SELECT \n");
        query.append("case when sales = 1 then 0 else reciept_goods.amount + reciept_goods.amount_discount end as amount,\n");
        query.append("case when sales = 1 then 0 else reciept_goods.amount end as amount_without_discount,\n");
        query.append("0 as amount_loyal_balls,\n");
        query.append("(case when reciept_goods.amount_discount < 0 then reciept_goods.amount_discount else 0 end) - 0 + (case when reciept_goods.amount_discount > 0 then reciept_goods.amount_discount else 0 end) as sum_discont, \n");
        query.append("reciept.date as check_date,\n");
        query.append("reciept.shopId as shop_id,\n");
        query.append("reciept.Id as check_number, \n");
        query.append("case when sales = 0 then 'cash' when sales = 1 then 'refoun' when sales = 2 then 'card' when sales = 3 then 'online' end as payment_method,\n");
        query.append("reciept_goods.quantity as quantity,\n");
        query.append("case when sales = 1 then reciept_goods.quantity else 0 end as refound_quantity,\n");
        query.append("case when sales = 1 then case when discount_total <> 0 then discount_total else Total end else 0 end as feround_amount,\n");
        query.append("good_categories.name as good_category,\n");
        query.append("shop.address as shop_address,\n");
        query.append("category_shop.name as category_shop_name,\n");
        query.append("good.name as good_name,good.id as good_id,\n");
        query.append("good_market.name as good_market_desc,\n");
        query.append("good_family.name as good_family_desc,\n");
        query.append("good_category.name as good_category_desc,\n");
        query.append("good.article as good_article,\n");
        query.append("region.name as region_name,\n");
        query.append("good.units as unit\n");
        query.append("FROM reciept\n");
        query.append("join\n");
        query.append("reciept_goods on (reciept.id = reciept_goods.recieptId and reciept.shopId = reciept_goods.shopId)\n");
        query.append("join \n");
        query.append("good on reciept_goods.goodId = good.Id\n");
        query.append("join\n");
        query.append("shop on reciept.shopId = shop.Id\n");
        query.append("left join \n");
        query.append("good_categories on good.category_id = good_categories.id\n");
        query.append("left join region on shop.regionId = region.id\n");
        query.append("left join good_market on good.good_market_id = good_market.id\n");
        query.append("left join good_category on good.good_category_id = good_category.id\n");
        query.append("left join good_family on good.good_family_id = good_family.id\n");
        query.append("left join category_shop on shop.category_shop_id = category_shop.id\n");
        query.append("where reciept.date between "+DateUtility.convertDateToStringWithQuotes(startDate)+" and "+DateUtility.convertDateToStringWithQuotes(endDate));
        query.append("\n");
        query.append("and reciept.ShopID = ");
        query.append(shopId);
        return query.toString();
    }

    public String getShopsSelectQuery(LocalDateTime startDate, LocalDateTime endDate) {
        StringBuilder builder = new StringBuilder();
        builder.append("SELECT DISTINCT ShopID FROM reciept where Date between ");
        builder.append(DateUtility.convertDateToStringWithQuotes(startDate));
        builder.append(" and ");
        builder.append(DateUtility.convertDateToStringWithQuotes(endDate));
        builder.append("");
        return builder.toString();
    }


}
