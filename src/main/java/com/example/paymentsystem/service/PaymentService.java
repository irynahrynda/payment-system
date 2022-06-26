package com.example.paymentsystem.service;

import com.example.paymentsystem.dto.PaymentRequestDto;
import com.example.paymentsystem.dto.PaymentResponseDto;
import java.util.List;

public interface PaymentService {
    PaymentResponseDto createPayment(PaymentRequestDto paymentRequestDto);

    List<PaymentResponseDto> createMultiplePayments(List<PaymentRequestDto> paymentRequestDto);
}
