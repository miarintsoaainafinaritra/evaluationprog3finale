package com.example.agriculture.Repository;

import com.example.agriculture.Model.CollectivityTransaction;

import java.time.LocalDate;
import java.util.List;

public interface CollectivityTransactionRepository {

    List<CollectivityTransaction> findByCollectivityIdAndTransactionDateBetween(
            String collectivityId,
            LocalDate from,
            LocalDate to
    );
}