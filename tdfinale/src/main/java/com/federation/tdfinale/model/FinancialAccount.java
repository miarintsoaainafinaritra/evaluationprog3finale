package com.federation.tdfinale.model;

import lombok.Data;

@Data
public class FinancialAccount {
    private String id;
    private String accountType;
    private String holderName;
    private String mobileBankingService;
    private Integer mobileNumber;
    private String bankName;
    private Integer bankCode;
    private Integer bankBranchCode;
    private Integer bankAccountNumber;
    private Integer bankAccountKey;
    private double amount;
}
