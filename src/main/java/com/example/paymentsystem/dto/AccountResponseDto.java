package com.example.paymentsystem.dto;

import com.example.paymentsystem.model.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class AccountResponseDto {
    @JsonProperty("account_id")
    private Long id;
    @JsonProperty("account_num")
    private Long accountNum;
    @JsonProperty("account_type")
    private AccountType accountType;
    private BigDecimal balance;
}
