package com.example.PaymentService.demo.PaymentService.Service;

import com.example.PaymentService.demo.PaymentService.Model.PaymentRequest;

public interface TransactionService
{

    public long doPayment(PaymentRequest paymentRequest);
}
