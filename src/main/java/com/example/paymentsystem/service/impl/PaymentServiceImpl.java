package com.example.paymentsystem.service.impl;

import com.example.paymentsystem.dto.PaymentRequestDto;
import com.example.paymentsystem.dto.PaymentResponseDto;
import com.example.paymentsystem.mappers.PaymentMapper;
import com.example.paymentsystem.model.Account;
import com.example.paymentsystem.model.Payment;
import com.example.paymentsystem.repository.AccountRepository;
import com.example.paymentsystem.repository.PaymentRepository;
import com.example.paymentsystem.service.PaymentService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final AccountRepository accountRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              AccountRepository accountRepository,
                              PaymentMapper paymentMapper) {
        this.paymentRepository = paymentRepository;
        this.accountRepository = accountRepository;
        this.paymentMapper = paymentMapper;
    }

    @Override
    public PaymentResponseDto createPayment(PaymentRequestDto paymentRequestDto) {
        Payment payment = paymentMapper.mapToModel(paymentRequestDto);
        Optional<Account> accountSource = accountRepository
                .findById(paymentRequestDto.getSourceAcc());
        Optional<Account> accountDest = accountRepository
                .findById(paymentRequestDto.getDestAcc());

        if (accountSource.isEmpty() || accountDest.isEmpty()) {
            throw new RuntimeException("SourceAccount or DestAccount is not present");
        }
        payment.setSourceAcc(accountSource.get());
        payment.setDestAcc(accountDest.get());

        if (accountSource.get().getBalance()
                .compareTo(paymentRequestDto.getAmount()) < 0) {
            payment.setTimestamp(LocalDateTime.now());
            payment.setPaymentStatus("error");
            paymentRepository.save(payment);
            throw new RuntimeException("Insufficient balance in the account");
        }

        accountSource.get().setBalance(accountSource.get().getBalance()
                .subtract(paymentRequestDto.getAmount()));
        accountDest.get().setBalance(accountDest.get().getBalance()
                .add(paymentRequestDto.getAmount()));
        payment.setTimestamp(LocalDateTime.now());
        payment.setPaymentStatus("ok");

        payment = paymentRepository.save(payment);
        return paymentMapper.mapToDto(payment);
    }

    @Override
    public List<PaymentResponseDto> createMultiplePayments(
            List<PaymentRequestDto> paymentRequestDto) {
        List<PaymentResponseDto> paymentResponseDtoList = new ArrayList<>();
        for (PaymentRequestDto requestDto : paymentRequestDto) {
            paymentResponseDtoList.add(createPayment(requestDto));
        }
        return paymentResponseDtoList;
    }
}
