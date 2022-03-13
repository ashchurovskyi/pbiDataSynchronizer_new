package com.barcom.pbiDataSynchronizer.factories;

import com.barcom.pbiDataSynchronizer.dto.PassShiftGeneralDTO;
import com.barcom.pbiDataSynchronizer.entities.ReportPassShift;
import com.barcom.pbiDataSynchronizer.utilities.DateUtility;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.HashMap;

@Component
public class PassShiftFactory {
    public PassShiftFactory() {
    }

    public ReportPassShift createPassShiftObject(PassShiftGeneralDTO generalShiftData, HashMap<String, HashMap<String, Double>> incomesMap, HashMap<String, Double> returnsMap, LocalDateTime startDate, LocalDateTime endDate, HashMap<String, Double> stocksMap) {
        String mapKey = generalShiftData.getShop_id().toString() + "_" + generalShiftData.getGood_id().toString();
        Double stocksForBegin = 0.0D;
        if (stocksMap.get(mapKey) != null) {
            stocksForBegin = (Double)stocksMap.get(mapKey);
        }

        Double returnsFromShop = 0.0D;
        if (returnsMap.get(mapKey) != null) {
            returnsFromShop = (Double)returnsMap.get(mapKey);
        }

        Double incomesToShop = 0.0D;
        Double incomesFromManufacture = 0.0D;
        HashMap<String, Double> incomesData = (HashMap)incomesMap.get(mapKey);
        if (incomesData != null) {
            incomesToShop = (Double)incomesData.get("checked_quantity");
            incomesFromManufacture = (Double)incomesData.get("quantity");
        }
        ReportPassShift shift = new ReportPassShift();
        shift.setShopDescription(generalShiftData.getShop_desc());
        shift.setGoodArticle(generalShiftData.getGood_article());
        shift.setGoodDesc(generalShiftData.getGood_name());
        shift.setGoodUnit(generalShiftData.getGood_units());
        shift.setQuantityStart(generalShiftData.getQuantity_start());
        shift.setQuantityFinish(generalShiftData.getQuantity_finish());
        shift.setDeviationQuantity(generalShiftData.getDeviation_quantity());
        shift.setIntervalDesc(this.buildIntervalDescription(startDate, endDate));
        shift.setCapacityInShop(stocksForBegin + incomesToShop - returnsFromShop);
        shift.setShopId(generalShiftData.getShop_id());
        shift.setCreationDate(generalShiftData.getCreation_date());
       return shift;
    }

    private String buildIntervalDescription(LocalDateTime startDate, LocalDateTime endDate) {
        String intervalDesc = DateUtility.convertDateToStringShortWithDots(startDate) + "-" + DateUtility.convertDateToStringShortWithDots(endDate);
        return intervalDesc;
    }
}
