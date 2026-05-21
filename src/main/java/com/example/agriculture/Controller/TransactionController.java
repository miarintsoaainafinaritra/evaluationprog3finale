package com.example.agriculture.Controller;

import com.example.agriculture.Model.CollectivityTransaction;
import com.example.agriculture.service.TransactionService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/collectivities/{id}/transactions")
    public List<CollectivityTransaction> getTransactionsByCollectivity(
            @PathVariable String id,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        return transactionService.getTransactionsByCollectivity(id, from, to);
    }
}