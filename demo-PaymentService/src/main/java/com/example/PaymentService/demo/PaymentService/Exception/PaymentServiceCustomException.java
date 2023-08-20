package com.example.PaymentService.demo.PaymentService.Exception;


import lombok.Data;

@Data
public class PaymentServiceCustomException extends RuntimeException{

    private String errorCode;
    private String message;


    public PaymentServiceCustomException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }
}
