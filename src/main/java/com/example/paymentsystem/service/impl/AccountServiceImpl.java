package com.example.paymentsystem.service.impl;

import com.example.paymentsystem.dto.AccountResponseDto;
import com.example.paymentsystem.mappers.AccountMapper;
import com.example.paymentsystem.model.Account;
import com.example.paymentsystem.repository.AccountRepository;
import com.example.paymentsystem.service.AccountService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    public AccountServiceImpl(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    @Override
    public List<AccountResponseDto> getClientAccounts(Long clientId) {
        List<Account> accountsByClientId = accountRepository.findAccountsByClientId(clientId);
        return accountsByClientId.stream()
                .map(accountMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
