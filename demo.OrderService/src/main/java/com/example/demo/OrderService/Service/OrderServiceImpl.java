package com.example.demo.OrderService.Service;


import com.example.demo.OrderService.Exception.OrderServiceCustomException;
import com.example.demo.OrderService.Model.*;
import com.example.demo.OrderService.Repository.OrderRepository;

import com.example.demo.OrderService.externalClient.PaymentService;
import com.example.demo.OrderService.externalClient.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

import static org.springframework.beans.BeanUtils.copyProperties;


@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private RestTemplate restTemplate;
    private static final Logger logger= LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private PaymentService paymentService;
    @Override
    public long placeOrder(OrderRequest orderRequest) {
        logger.info("Placing Order Request :{}",orderRequest);
         productService.reduceQuantity(orderRequest.getProductId(),orderRequest.getQuantity());
        logger.info("Invoking Order service");
        logger.info("Creating Order with status CREATED");
        Order order= Order.builder().productId(orderRequest.getProductId())
                .amount(orderRequest.getAmount())
                .quantity(orderRequest.getQuantity())
                .orderDate(Instant.now())
                .orderStatus("CREATED").build();
          orderRepository.save(order);
        logger.info("Order Placed");

        PaymentRequest paymentRequest=PaymentRequest.builder()
                .orderId(order.getId())
                .paymentMode(orderRequest.getPaymentMode())
                .amount(order.getAmount())
                .build();

        String orderStatus=null;
        try{

            paymentService.doPayment(paymentRequest);
            logger.info("Payment done");

        }catch(Exception e){

            logger.error("Error in payment");
            orderStatus="PAYMENT_FAILED";

        }
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
        return order.getId();
    }

    @Override
    public OrderResponse getOrder(long id) {
        String url = "http://PRODUCT-SERVICE/product";
        logger.info("get Product");
        Order order = orderRepository.findById(id).orElseThrow(()->new OrderServiceCustomException("Order not found","ORDER_NOT_PLACED"));
        ProductResponse productReponse =restTemplate.getForObject(url +order.getProductId(), ProductResponse.class);
        OrderResponse.ProductDetails productDetails=OrderResponse.ProductDetails.builder()
               .name(productReponse.getName())
               .productId(productReponse.getProductId())
               .price(productReponse.getPrice())
               .quantity(productReponse.getQuantity()).build();

        OrderResponse orderResponse=OrderResponse.builder().orderId(order.getId())
                .orderStatus(order.getOrderStatus()).orderDate(order.getOrderDate())
                .productDetails(productDetails)
                .orderStatus(order.getOrderStatus())
                .amount(order.getAmount())
                .build();
        return orderResponse;
    }


}
