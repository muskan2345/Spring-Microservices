package com.example.demo.OrderService.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse
{

    private long orderId;

    private Instant orderDate;


    private String orderStatus;

    private long amount;
    private ProductDetails productDetails;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductDetails
    {

        private long productId;
        private String name;
        private long price;
        private long quantity;
    }



}
