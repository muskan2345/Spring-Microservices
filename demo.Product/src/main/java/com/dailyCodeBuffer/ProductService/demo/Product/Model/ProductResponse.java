package com.dailyCodeBuffer.ProductService.demo.Product.Model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse
{


    private long productId;
    private String name;
    private long price;
    private long quantity;
}
