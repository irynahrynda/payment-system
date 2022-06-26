package com.example.paymentsystem.service.impl;

import com.example.paymentsystem.dto.ClientRequestDto;
import com.example.paymentsystem.dto.ClientResponseDto;
import com.example.paymentsystem.mappers.ClientMapper;
import com.example.paymentsystem.model.Client;
import com.example.paymentsystem.repository.ClientRepository;
import com.example.paymentsystem.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public ClientServiceImpl(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    @Override
    public ClientResponseDto createClient(ClientRequestDto clientRequestDto) {
        Client client = clientMapper.mapToModel(clientRequestDto);
        client = clientRepository.save(client);
        return clientMapper.mapToDto(client);
    }
}
