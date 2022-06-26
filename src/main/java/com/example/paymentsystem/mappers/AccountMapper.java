package com.example.paymentsystem.mappers;

import com.example.paymentsystem.dto.AccountRequestDto;
import com.example.paymentsystem.dto.AccountResponseDto;
import com.example.paymentsystem.model.Account;
import com.example.paymentsystem.model.Client;
import com.example.paymentsystem.model.enums.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public Account mapToModel(AccountRequestDto requestDto, Client client) {
        Account account = new Account();
        account.setAccountNum(requestDto.getAccountNum());
        account.setBalance(requestDto.getBalance());
        account.setClient(client);
        account.setAccountType(AccountType.valueOf(requestDto.getAccountType().name()));
        return account;
    }

    public AccountResponseDto mapToDto(Account account) {
        AccountResponseDto accountResponseDto = new AccountResponseDto();
        accountResponseDto.setId(account.getId());
        accountResponseDto.setAccountNum(account.getAccountNum());
        accountResponseDto.setAccountType(account.getAccountType());
        accountResponseDto.setBalance(account.getBalance());
        return accountResponseDto;
    }
}
