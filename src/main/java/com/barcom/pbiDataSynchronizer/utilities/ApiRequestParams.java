package com.barcom.pbiDataSynchronizer.utilities;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.Objects;

public class ApiRequestParams {
    @ApiModelProperty(name = "shops",
            value = "Перелік магазинів для завантаження. Для завантаження по всих магазинах потрібно передати пустий масив '[]'",
            example = "[]")
    private ArrayList<Integer> shops;

    @ApiModelProperty(name = "dates",
            value = "Перелік дат для завантаження. Обов'язковий реквізит",
            example = "[\"2021-11-01 00:00:00\"]")
    private ArrayList<String> dates;

    public ArrayList<Integer> getShops() {
        return shops;
    }

    public void setShops(ArrayList<Integer> shops) {
        this.shops = shops;
    }

    public ArrayList<String> getDates() {
        return dates;
    }

    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiRequestParams that = (ApiRequestParams) o;
        return Objects.equals(shops, that.shops) && Objects.equals(dates, that.dates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shops, dates);
    }

}
