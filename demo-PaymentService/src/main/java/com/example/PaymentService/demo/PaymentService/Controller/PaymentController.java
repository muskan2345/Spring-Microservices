package com.example.PaymentService.demo.PaymentService.Controller;


import com.example.PaymentService.demo.PaymentService.Model.PaymentRequest;
import com.example.PaymentService.demo.PaymentService.Service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("payment")
public class PaymentController
{

    private static final Logger logger= LoggerFactory.getLogger(TransactionService.class);


    @Autowired
    private TransactionService transactionService;

    @PostMapping("/Add-Payment")
    public ResponseEntity<Long> doPayment(@RequestBody  PaymentRequest paymentRequest){

        return new ResponseEntity<>(transactionService.doPayment(paymentRequest), HttpStatus.OK);

    }

}
