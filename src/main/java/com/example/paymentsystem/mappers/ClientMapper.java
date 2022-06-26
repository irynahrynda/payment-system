package com.example.paymentsystem.mappers;

import com.example.paymentsystem.dto.ClientRequestDto;
import com.example.paymentsystem.dto.ClientResponseDto;
import com.example.paymentsystem.model.Client;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    private final AccountMapper accountMapper;

    public ClientMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public Client mapToModel(ClientRequestDto clientRequestDto) {
        Client client = new Client();
        client.setFirstName(clientRequestDto.getFirstName());
        client.setLastName(clientRequestDto.getLastName());
        client.setAccounts(clientRequestDto.getAccounts()
                .stream()
                .map(a -> accountMapper.mapToModel(a, client))
                .collect(Collectors.toList()));
        return client;
    }

    public ClientResponseDto mapToDto(Client client) {
        ClientResponseDto clientResponseDto = new ClientResponseDto();
        clientResponseDto.setId(client.getId());
        return clientResponseDto;
    }
}
