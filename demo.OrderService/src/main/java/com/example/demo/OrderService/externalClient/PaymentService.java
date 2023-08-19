package com.example.demo.OrderService.externalClient;


import com.example.demo.OrderService.Model.PaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value="PAYMENT-SERVICE/payment")
public interface PaymentService
{

    @PostMapping("/Add-Payment")
    public ResponseEntity<Long> doPayment(@RequestBody PaymentRequest paymentRequest);




}
