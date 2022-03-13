package com.barcom.pbiDataSynchronizer.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "report_receipts")
public class ReportReceipts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "amount_without_discount")
    private double amountWithoutDiscount;

    @Column(name = "amount_loyal_balls")
    private double amountLoyaltyBalls;

    @Column(name = "sum_discont")
    private double sumDiscount;

    @Column(name = "check_date")
    private LocalDateTime check_date;

    @Column(name = "shop_id")
    private int shopId;

    @Column(name = "check_number")
    private int checkNumber;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "quantity")
    private double quantity;

    @Column(name = "refound_quantity")
    private double refundQuantity;

    @Column(name = "feround_amount")
    private double refundAmount;

    @Column(name = "good_category")
    private String goodCategory;

    @Column(name = "shop_address")
    private String shopAddress;

    @Column(name = "category_shop_name")
    private String categoryShopName;

    @Column(name = "good_name")
    private String goodName;

    @Column(name = "good_id")
    private int goodId;

    @Column(name = "good_market_desc")
    private String goodMarketDesc;

    @Column(name = "good_family_desc")
    private String goodFamilyDesc;

    @Column(name = "good_category_desc")
    private String goodCategoryDesc;

    @Column(name = "good_article")
    private String goodArticle;

    @Column(name = "region_name")
    private String regionName;

    @Column(name = "unit")
    private String unit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmountWithoutDiscount() {
        return amountWithoutDiscount;
    }

    public void setAmountWithoutDiscount(double amountWithoutDiscount) {
        this.amountWithoutDiscount = amountWithoutDiscount;
    }

    public double getAmountLoyaltyBalls() {
        return amountLoyaltyBalls;
    }

    public void setAmountLoyaltyBalls(double amountLoyaltyBalls) {
        this.amountLoyaltyBalls = amountLoyaltyBalls;
    }

    public double getSumDiscount() {
        return sumDiscount;
    }

    public void setSumDiscount(double sumDiscount) {
        this.sumDiscount = sumDiscount;
    }

    public LocalDateTime getCheck_date() {
        return check_date;
    }

    public void setCheck_date(LocalDateTime check_date) {
        this.check_date = check_date;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getRefundQuantity() {
        return refundQuantity;
    }

    public void setRefundQuantity(double refundQuantity) {
        this.refundQuantity = refundQuantity;
    }

    public double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getGoodCategory() {
        return goodCategory;
    }

    public void setGoodCategory(String goodCategory) {
        this.goodCategory = goodCategory;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getCategoryShopName() {
        return categoryShopName;
    }

    public void setCategoryShopName(String categoryShopName) {
        this.categoryShopName = categoryShopName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public String getGoodMarketDesc() {
        return goodMarketDesc;
    }

    public void setGoodMarketDesc(String goodMarketDesc) {
        this.goodMarketDesc = goodMarketDesc;
    }

    public String getGoodFamilyDesc() {
        return goodFamilyDesc;
    }

    public void setGoodFamilyDesc(String goodFamilyDesc) {
        this.goodFamilyDesc = goodFamilyDesc;
    }

    public String getGoodCategoryDesc() {
        return goodCategoryDesc;
    }

    public void setGoodCategoryDesc(String goodCategoryDesc) {
        this.goodCategoryDesc = goodCategoryDesc;
    }

    public String getGoodArticle() {
        return goodArticle;
    }

    public void setGoodArticle(String goodArticle) {
        this.goodArticle = goodArticle;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
