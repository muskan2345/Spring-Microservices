package com.example.PaymentService.demo.PaymentService.Service;

import com.example.PaymentService.demo.PaymentService.Model.PaymentRequest;
import com.example.PaymentService.demo.PaymentService.Model.PaymentResponse;

public interface TransactionService
{

    public long doPayment(PaymentRequest paymentRequest);

    public PaymentResponse getPayment(long id);
}
