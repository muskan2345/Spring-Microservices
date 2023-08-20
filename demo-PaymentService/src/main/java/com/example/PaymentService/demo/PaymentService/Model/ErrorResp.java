package com.example.PaymentService.demo.PaymentService.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorResp
{
    private String errorMessage;
    private String errorCode;


}
