package com.barcom.pbiDataSynchronizer.dto;

public class IncomesToShopDTO {

    private Integer good_id;
    private Integer shop_id;
    private Double quantity;
    private Double checked_quantity;

    public IncomesToShopDTO() {
    }

    public Integer getGood_id() {
        return this.good_id;
    }

    public Integer getShop_id() {
        return this.shop_id;
    }

    public Double getQuantity() {
        return this.quantity;
    }

    public Double getChecked_quantity() {
        return this.checked_quantity;
    }

    public void setGood_id(final Integer good_id) {
        this.good_id = good_id;
    }

    public void setShop_id(final Integer shop_id) {
        this.shop_id = shop_id;
    }

    public void setQuantity(final Double quantity) {
        this.quantity = quantity;
    }

    public void setChecked_quantity(final Double checked_quantity) {
        this.checked_quantity = checked_quantity;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof IncomesToShopDTO)) {
            return false;
        } else {
            IncomesToShopDTO other = (IncomesToShopDTO)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                label59: {
                    Object this$good_id = this.getGood_id();
                    Object other$good_id = other.getGood_id();
                    if (this$good_id == null) {
                        if (other$good_id == null) {
                            break label59;
                        }
                    } else if (this$good_id.equals(other$good_id)) {
                        break label59;
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

                Object this$quantity = this.getQuantity();
                Object other$quantity = other.getQuantity();
                if (this$quantity == null) {
                    if (other$quantity != null) {
                        return false;
                    }
                } else if (!this$quantity.equals(other$quantity)) {
                    return false;
                }

                Object this$checked_quantity = this.getChecked_quantity();
                Object other$checked_quantity = other.getChecked_quantity();
                if (this$checked_quantity == null) {
                    if (other$checked_quantity != null) {
                        return false;
                    }
                } else if (!this$checked_quantity.equals(other$checked_quantity)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof IncomesToShopDTO;
    }



    public String toString() {
        return "IncomesToShopDTO(good_id=" + this.getGood_id() + ", shop_id=" + this.getShop_id() + ", quantity=" + this.getQuantity() + ", checked_quantity=" + this.getChecked_quantity() + ")";
    }
}
