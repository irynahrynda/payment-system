package com.example.paymentsystem.controller;

import com.example.paymentsystem.dto.AccountResponseDto;
import com.example.paymentsystem.service.AccountService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public List<AccountResponseDto> getAccountsById(@RequestParam Long clientId) {
        return accountService.getClientAccounts(clientId);
    }
}
