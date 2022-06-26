package com.example.paymentsystem.service;

import com.example.paymentsystem.dto.AccountResponseDto;
import java.util.List;

public interface AccountService {
    List<AccountResponseDto> getClientAccounts(Long clientId);
}
