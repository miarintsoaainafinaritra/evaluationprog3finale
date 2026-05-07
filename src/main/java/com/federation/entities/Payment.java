package com.federation.entities;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Payment {
    private String memberName;
    private Double amount;
    private LocalDateTime paymentDate;
}
