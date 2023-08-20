package com.example.PaymentService.demo.PaymentService.Model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;


@Data
@Builder
public class PaymentResponse {

    private long id;
    private long orderId;
    private long amount;

    private String referenceNumber;


    private PaymentMode paymentMode;

    private OrderDetails orderDetails;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class OrderDetails {

        private long orderId;

        private Instant orderDate;


        private String orderStatus;

        private long amount;
        private ProductDetails productDetails;

        @Data
        @Builder
        @NoArgsConstructor
        @AllArgsConstructor
        public static class ProductDetails {

            private long productId;
            private String name;
            private long price;
            private long quantity;
        }


    }
}
