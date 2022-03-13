package com.barcom.pbiDataSynchronizer.dto;

public class StocksInShopDTO {
    private Integer good_id;
    private Integer shop_id;
    private Double stock_quantity;

    public StocksInShopDTO() {
    }

    public Integer getGood_id() {
        return this.good_id;
    }

    public Integer getShop_id() {
        return this.shop_id;
    }

    public Double getStock_quantity() {
        return this.stock_quantity;
    }

    public void setGood_id(final Integer good_id) {
        this.good_id = good_id;
    }

    public void setShop_id(final Integer shop_id) {
        this.shop_id = shop_id;
    }

    public void setStock_quantity(final Double stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof StocksInShopDTO)) {
            return false;
        } else {
            StocksInShopDTO other = (StocksInShopDTO)o;
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

                Object this$stock_quantity = this.getStock_quantity();
                Object other$stock_quantity = other.getStock_quantity();
                if (this$stock_quantity == null) {
                    if (other$stock_quantity != null) {
                        return false;
                    }
                } else if (!this$stock_quantity.equals(other$stock_quantity)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StocksInShopDTO;
    }

    public String toString() {
        return "StocksInShopDTO(good_id=" + this.getGood_id() + ", shop_id=" + this.getShop_id() + ", stock_quantity=" + this.getStock_quantity() + ")";
    }
}
