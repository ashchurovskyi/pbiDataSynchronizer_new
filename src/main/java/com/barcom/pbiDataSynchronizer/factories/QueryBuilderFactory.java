package com.barcom.pbiDataSynchronizer.factories;

import java.time.LocalDateTime;

public interface QueryBuilderFactory {
    default String getShopsSelectQuery() {

        return null;
    };

    default String getShopsSelectQuery(LocalDateTime startDate, LocalDateTime endDate) {
        return null;
    };
}
