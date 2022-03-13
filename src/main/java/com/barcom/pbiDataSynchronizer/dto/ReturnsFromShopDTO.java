package com.barcom.pbiDataSynchronizer.dto;

public class ReturnsFromShopDTO {
    private Integer good_id;
    private Integer shop_id;
    private Double return_quantity;

    public ReturnsFromShopDTO() {
    }

    public Integer getGood_id() {
        return this.good_id;
    }

    public Integer getShop_id() {
        return this.shop_id;
    }

    public Double getReturn_quantity() {
        return this.return_quantity;
    }

    public void setGood_id(final Integer good_id) {
        this.good_id = good_id;
    }

    public void setShop_id(final Integer shop_id) {
        this.shop_id = shop_id;
    }

    public void setReturn_quantity(final Double return_quantity) {
        this.return_quantity = return_quantity;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof ReturnsFromShopDTO)) {
            return false;
        } else {
            ReturnsFromShopDTO other = (ReturnsFromShopDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label47: {
                    Object this$good_id = this.getGood_id();
                    Object other$good_id = other.getGood_id();
                    if (this$good_id == null) {
                        if (other$good_id == null) {
                            break label47;
                        }
                    } else if (this$good_id.equals(other$good_id)) {
                        break label47;
                    }

                    return false;
                }

                Object this$shop_id = this.getShop_id();
                Object other$shop_id = other.getShop_id();
                if (this$shop_id == null) {
                    if (other$shop_id != null) {
                        return false;
                    }
                } else if (!this$shop_id.equals(other$shop_id)) {
                    return false;
                }

                Object this$return_quantity = this.getReturn_quantity();
                Object other$return_quantity = other.getReturn_quantity();
                if (this$return_quantity == null) {
                    if (other$return_quantity != null) {
                        return false;
                    }
                } else if (!this$return_quantity.equals(other$return_quantity)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ReturnsFromShopDTO;
    }



    public String toString() {
        return "ReturnsFromShopDTO(good_id=" + this.getGood_id() + ", shop_id=" + this.getShop_id() + ", return_quantity=" + this.getReturn_quantity() + ")";
    }
}
