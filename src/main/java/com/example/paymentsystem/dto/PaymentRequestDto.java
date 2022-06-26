package com.example.paymentsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class PaymentRequestDto {
    @JsonProperty("source_acc_id")
    private Long sourceAcc;
    @JsonProperty("dest_acc_id")
    private Long destAcc;
    private BigDecimal amount;
    private String reason;
}
