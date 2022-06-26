package com.example.paymentsystem.mappers;

import com.example.paymentsystem.dto.PaymentRequestDto;
import com.example.paymentsystem.dto.PaymentResponseDto;
import com.example.paymentsystem.model.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {
    private final AccountMapper accountMapper;

    public PaymentMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    public Payment mapToModel(PaymentRequestDto paymentRequestDto) {
        Payment payment = new Payment();
        payment.setReason(paymentRequestDto.getReason());
        payment.setAmount(paymentRequestDto.getAmount());
        return payment;
    }

    public PaymentResponseDto mapToDto(Payment payment) {
        PaymentResponseDto paymentResponseDto = new PaymentResponseDto();
        paymentResponseDto.setId(payment.getId());
        paymentResponseDto.setPaymentStatus(payment.getPaymentStatus());
        return paymentResponseDto;
    }
}
