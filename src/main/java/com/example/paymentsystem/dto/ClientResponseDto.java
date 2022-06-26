package com.example.paymentsystem.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientResponseDto {
    @JsonProperty("client_id")
    private Long id;
}
