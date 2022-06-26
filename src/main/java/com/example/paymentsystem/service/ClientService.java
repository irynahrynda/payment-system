package com.example.paymentsystem.service;

import com.example.paymentsystem.dto.ClientRequestDto;
import com.example.paymentsystem.dto.ClientResponseDto;

public interface ClientService {
    ClientResponseDto createClient(ClientRequestDto clientRequestDto);
}
