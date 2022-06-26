package com.example.paymentsystem.controller;

import com.example.paymentsystem.dto.ClientRequestDto;
import com.example.paymentsystem.dto.ClientResponseDto;
import com.example.paymentsystem.mappers.ClientMapper;
import com.example.paymentsystem.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService, ClientMapper clientMapper) {
        this.clientService = clientService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClientResponseDto createClient(@RequestBody ClientRequestDto clientRequestDto) {
        return clientService.createClient(clientRequestDto);
    }
}
