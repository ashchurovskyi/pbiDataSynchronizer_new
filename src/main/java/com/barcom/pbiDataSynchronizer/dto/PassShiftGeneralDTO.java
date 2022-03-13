package com.barcom.pbiDataSynchronizer.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class PassShiftGeneralDTO {
    private Integer shop_id;
    private String shop_desc;
    private LocalDateTime creation_date;
    private Date accept_date;
    private boolean is_accepted;
    private String good_article;
    private Integer good_id;
    private String good_name;
    private String good_units;
    private Double good_price;
    private Double quantity_start;
    private Double quantity_finish;
    private Double deviation_quantity;

    public PassShiftGeneralDTO() {
    }

    public Integer getShop_id() {
        return this.shop_id;
    }

    public String getShop_desc() {
        return this.shop_desc;
    }

    public LocalDateTime getCreation_date() {
        return this.creation_date;
    }

    public Date getAccept_date() {
        return this.accept_date;
    }

    public boolean is_accepted() {
        return this.is_accepted;
    }

    public String getGood_article() {
        return this.good_article;
    }

    public Integer getGood_id() {
        return this.good_id;
    }

    public String getGood_name() {
        return this.good_name;
    }

    public String getGood_units() {
        return this.good_units;
    }

    public Double getGood_price() {
        return this.good_price;
    }

    public Double getQuantity_start() {
        return this.quantity_start;
    }

    public Double getQuantity_finish() {
        return this.quantity_finish;
    }

    public Double getDeviation_quantity() {
        return this.deviation_quantity;
    }

    public void setShop_id(final Integer shop_id) {
        this.shop_id = shop_id;
    }

    public void setShop_desc(final String shop_desc) {
        this.shop_desc = shop_desc;
    }

    public void setCreation_date(final LocalDateTime creation_date) {
        this.creation_date = creation_date;
    }

    public void setAccept_date(final Date accept_date) {
        this.accept_date = accept_date;
    }

    public void set_accepted(final boolean is_accepted) {
        this.is_accepted = is_accepted;
    }

    public void setGood_article(final String good_article) {
        this.good_article = good_article;
    }

    public void setGood_id(final Integer good_id) {
        this.good_id = good_id;
    }

    public void setGood_name(final String good_name) {
        this.good_name = good_name;
    }

    public void setGood_units(final String good_units) {
        this.good_units = good_units;
    }

    public void setGood_price(final Double good_price) {
        this.good_price = good_price;
    }

    public void setQuantity_start(final Double quantity_start) {
        this.quantity_start = quantity_start;
    }

    public void setQuantity_finish(final Double quantity_finish) {
        this.quantity_finish = quantity_finish;
    }

    public void setDeviation_quantity(final Double deviation_quantity) {
        this.deviation_quantity = deviation_quantity;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PassShiftGeneralDTO)) {
            return false;
        } else {
            PassShiftGeneralDTO other = (PassShiftGeneralDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.is_accepted() != other.is_accepted()) {
                return false;
            } else {
                label157: {
                    Object this$shop_id = this.getShop_id();
                    Object other$shop_id = other.getShop_id();
                    if (this$shop_id == null) {
                        if (other$shop_id == null) {
                            break label157;
                        }
                    } else if (this$shop_id.equals(other$shop_id)) {
                        break label157;
                    }

                    return false;
                }

                label150: {
                    Object this$good_id = this.getGood_id();
                    Object other$good_id = other.getGood_id();
                    if (this$good_id == null) {
                        if (other$good_id == null) {
                            break label150;
                        }
                    } else if (this$good_id.equals(other$good_id)) {
                        break label150;
                    }

                    return false;
                }

                Object this$good_price = this.getGood_price();
                Object other$good_price = other.getGood_price();
                if (this$good_price == null) {
                    if (other$good_price != null) {
                        return false;
                    }
                } else if (!this$good_price.equals(other$good_price)) {
                    return false;
                }

                label136: {
                    Object this$quantity_start = this.getQuantity_start();
                    Object other$quantity_start = other.getQuantity_start();
                    if (this$quantity_start == null) {
                        if (other$quantity_start == null) {
                            break label136;
                        }
                    } else if (this$quantity_start.equals(other$quantity_start)) {
                        break label136;
                    }

                    return false;
                }

                Object this$quantity_finish = this.getQuantity_finish();
                Object other$quantity_finish = other.getQuantity_finish();
                if (this$quantity_finish == null) {
                    if (other$quantity_finish != null) {
                        return false;
                    }
                } else if (!this$quantity_finish.equals(other$quantity_finish)) {
                    return false;
                }

                label122: {
                    Object this$deviation_quantity = this.getDeviation_quantity();
                    Object other$deviation_quantity = other.getDeviation_quantity();
                    if (this$deviation_quantity == null) {
                        if (other$deviation_quantity == null) {
                            break label122;
                        }
                    } else if (this$deviation_quantity.equals(other$deviation_quantity)) {
                        break label122;
                    }

                    return false;
                }

                Object this$shop_desc = this.getShop_desc();
                Object other$shop_desc = other.getShop_desc();
                if (this$shop_desc == null) {
                    if (other$shop_desc != null) {
                        return false;
                    }
                } else if (!this$shop_desc.equals(other$shop_desc)) {
                    return false;
                }

                Object this$creation_date = this.getCreation_date();
                Object other$creation_date = other.getCreation_date();
                if (this$creation_date == null) {
                    if (other$creation_date != null) {
                        return false;
                    }
                } else if (!this$creation_date.equals(other$creation_date)) {
                    return false;
                }

                Object this$accept_date = this.getAccept_date();
                Object other$accept_date = other.getAccept_date();
                if (this$accept_date == null) {
                    if (other$accept_date != null) {
                        return false;
                    }
                } else if (!this$accept_date.equals(other$accept_date)) {
                    return false;
                }

                label94: {
                    Object this$good_article = this.getGood_article();
                    Object other$good_article = other.getGood_article();
                    if (this$good_article == null) {
                        if (other$good_article == null) {
                            break label94;
                        }
                    } else if (this$good_article.equals(other$good_article)) {
                        break label94;
                    }

                    return false;
                }

                label87: {
                    Object this$good_name = this.getGood_name();
                    Object other$good_name = other.getGood_name();
                    if (this$good_name == null) {
                        if (other$good_name == null) {
                            break label87;
                        }
                    } else if (this$good_name.equals(other$good_name)) {
                        break label87;
                    }

                    return false;
                }

                Object this$good_units = this.getGood_units();
                Object other$good_units = other.getGood_units();
                if (this$good_units == null) {
                    if (other$good_units != null) {
                        return false;
                    }
                } else if (!this$good_units.equals(other$good_units)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof PassShiftGeneralDTO;
    }


    public String toString() {
        return "PassShiftGeneralDTO(shop_id=" + this.getShop_id() + ", shop_desc=" + this.getShop_desc() + ", creation_date=" + this.getCreation_date() + ", accept_date=" + this.getAccept_date() + ", is_accepted=" + this.is_accepted() + ", good_article=" + this.getGood_article() + ", good_id=" + this.getGood_id() + ", good_name=" + this.getGood_name() + ", good_units=" + this.getGood_units() + ", good_price=" + this.getGood_price() + ", quantity_start=" + this.getQuantity_start() + ", quantity_finish=" + this.getQuantity_finish() + ", deviation_quantity=" + this.getDeviation_quantity() + ")";
    }

}
