package com.dailyCodeBuffer.ProductService.demo.Product.Model;


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
