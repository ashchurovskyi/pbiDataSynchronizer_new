package com.barcom.pbiDataSynchronizer.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "report_pass_shift")
public class ReportPassShift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="shop_desc")
    private String shopDescription;

    @Column(name="good_article")
    private String goodArticle;

    @Column(name="good_desc")
    private String goodDesc;

    @Column(name="good_units")
    private String goodUnit;

    @Column(name="quantity_start")
    private double quantityStart;

    @Column(name="quantity_finish")
    private double quantityFinish;

    @Column(name="deviation_quantity")
    private double deviationQuantity;

    @Column(name="incomes_to_shop")
    private double incomesToShop;

    @Column(name="quantity_from_manufactory")
    private double quantityFromManufactory;

    @Column(name="return_quantity")
    private double returnQuantity;

    @Column(name="stocks_quantity_for_begin")
    private double stocksQuantityForBegin;

    @Column(name="interval_desc")
    private String intervalDesc;

    @Column(name="capacity_in_shop")
    private double capacityInShop;

    @Column(name="shop_id")
    private int shopId;

    @Column(name="creation_date")
    private LocalDateTime creationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGoodDesc() {
        return goodDesc;
    }

    public void setGoodDesc(String goodDesc) {
        this.goodDesc = goodDesc;
    }

    public String getGoodUnit() {
        return goodUnit;
    }

    public void setGoodUnit(String goodUnit) {
        this.goodUnit = goodUnit;
    }

    public double getQuantityStart() {
        return quantityStart;
    }

    public void setQuantityStart(double quantityStart) {
        this.quantityStart = quantityStart;
    }

    public double getQuantityFinish() {
        return quantityFinish;
    }

    public void setQuantityFinish(double quantityFinish) {
        this.quantityFinish = quantityFinish;
    }

    public double getDeviationQuantity() {
        return deviationQuantity;
    }

    public void setDeviationQuantity(double deviationQuantity) {
        this.deviationQuantity = deviationQuantity;
    }

    public double getIncomesToShop() {
        return incomesToShop;
    }

    public void setIncomesToShop(double incomesToShop) {
        this.incomesToShop = incomesToShop;
    }

    public double getQuantityFromManufactory() {
        return quantityFromManufactory;
    }

    public void setQuantityFromManufactory(double quantityFromManufactory) {
        this.quantityFromManufactory = quantityFromManufactory;
    }

    public double getReturnQuantity() {
        return returnQuantity;
    }

    public void setReturnQuantity(double returnQuantity) {
        this.returnQuantity = returnQuantity;
    }

    public double getStocksQuantityForBegin() {
        return stocksQuantityForBegin;
    }

    public void setStocksQuantityForBegin(double stocksQuantityForBegin) {
        this.stocksQuantityForBegin = stocksQuantityForBegin;
    }

    public String getIntervalDesc() {
        return intervalDesc;
    }

    public void setIntervalDesc(String intervalDesc) {
        this.intervalDesc = intervalDesc;
    }

    public double getCapacityInShop() {
        return capacityInShop;
    }

    public void setCapacityInShop(double capacityInShop) {
        this.capacityInShop = capacityInShop;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
