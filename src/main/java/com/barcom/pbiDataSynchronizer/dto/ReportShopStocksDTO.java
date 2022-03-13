package com.barcom.pbiDataSynchronizer.dto;

import com.barcom.pbiDataSynchronizer.entities.ReportShopStocks;

import java.time.LocalDateTime;
import java.util.Date;

public class ReportShopStocksDTO {

    private int shopId;

    private String shopDescription;

    private String goodArticle;

    private String goodDescription;

    private double stockQuantity;

    private LocalDateTime stockDate;

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

        return true;
    }

    public ReportShopStocks convertToFinalEntity(){
        ReportShopStocks entity = new ReportShopStocks();
        entity.setGoodArticle(this.goodArticle);
        entity.setGoodDescription(this.goodDescription);
        entity.setShopId(this.shopId);
        entity.setShopDescription(this.shopDescription);
        entity.setStockDate(this.stockDate);
        entity.setStockQuantity(this.stockQuantity);
        return entity;
    }

}
