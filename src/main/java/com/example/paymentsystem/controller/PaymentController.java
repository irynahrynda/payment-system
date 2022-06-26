package com.example.paymentsystem.controller;

import com.example.paymentsystem.dto.PaymentRequestDto;
import com.example.paymentsystem.dto.PaymentResponseDto;
import com.example.paymentsystem.service.PaymentService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaymentResponseDto createPayment(@RequestBody PaymentRequestDto paymentRequestDto) {
        return paymentService.createPayment(paymentRequestDto);
    }

    @PostMapping("/multiple")
    public List<PaymentResponseDto> createMultiplePayments(
            @RequestBody List<PaymentRequestDto> paymentRequestDtos) {
        return paymentService.createMultiplePayments(paymentRequestDtos);
    }
}
