package com.barcom.pbiDataSynchronizer.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="report_shop_stocks")
public class ReportShopStocks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="shop_id")
    private int shopId;

    @Column(name="shop_desc")
    private String shopDescription;

    @Column(name="good_article")
    private String goodArticle;

    @Column(name="good_desc")
    private String goodDescription;

    @Column(name="stock_quantity")
    private double stockQuantity;

    @Column(name="stock_date")
    private LocalDateTime stockDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public String getShopDescription() {
        return shopDescription;
    }

    public void setShopDescription(String shopDescription) {
        this.shopDescription = shopDescription;
    }

    public String getGoodArticle() {
        return goodArticle;
    }

    public void setGoodArticle(String goodArticle) {
        this.goodArticle = goodArticle;
    }

    public String getGoodDescription() {
        return goodDescription;
    }

    public void setGoodDescription(String goodDescription) {
        this.goodDescription = goodDescription;
    }

    public double getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(double stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public LocalDateTime getStockDate() {
        return stockDate;
    }

    public void setStockDate(LocalDateTime stockDate) {
        this.stockDate = stockDate;
    }

    @Override
    public int hashCode(){
        final int prime = 31;

        int result =0;

        result += prime*this.id;
        result += prime*this.shopId;
        result =+ prime*(this.goodArticle==null?0:this.goodArticle.hashCode());
        result =+ prime*(this.stockDate==null?0:this.stockDate.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj){

        if (this == obj ){
            return true;
        }
        if (obj==null){
            return false;
        }

        if (getClass() != obj.getClass()){
            return false;
        }

        if (hashCode()!=obj.hashCode()){
            return false;
        }

        return false;
    }

}
