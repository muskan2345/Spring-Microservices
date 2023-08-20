package com.example.PaymentService.demo.PaymentService.Service;


import com.example.PaymentService.demo.PaymentService.Entity.TransactionDetails;
import com.example.PaymentService.demo.PaymentService.Exception.PaymentServiceCustomException;
import com.example.PaymentService.demo.PaymentService.Model.OrderResponse;
import com.example.PaymentService.demo.PaymentService.Model.PaymentMode;
import com.example.PaymentService.demo.PaymentService.Model.PaymentRequest;
import com.example.PaymentService.demo.PaymentService.Model.PaymentResponse;
import com.example.PaymentService.demo.PaymentService.Repository.PaymentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static ch.qos.logback.classic.spi.ThrowableProxyVO.build;

@Service
public class TransactionServiceImpl  implements TransactionService
{


 @Autowired
 PaymentRepository paymentRepository;




 @Autowired
    PaymentResponse.OrderDetails orderDetails;

 @Autowired
    public RestTemplate restTemplate;
    private static final Logger logger= LoggerFactory.getLogger(TransactionService.class);


    @Override
    public long doPayment(PaymentRequest paymentRequest) {
       logger.info("Recording Payment Details :{}",paymentRequest);

       TransactionDetails transaction=TransactionDetails.builder().orderId(paymentRequest.getOrderId()).amount(paymentRequest.getAmount())
               .referenceNumber(paymentRequest.getReferenceNumber()).paymentMode(paymentRequest.getPaymentMode().name()).build();
       paymentRepository.save(transaction);
        logger.info(" Payment Completed :{}",transaction);
       return transaction.getId();

    }

    @Override
    public PaymentResponse getPayment(long id) {

        logger.info("get transaction Details");


        TransactionDetails transactionDetails = paymentRepository.findById(id).orElseThrow(() -> new PaymentServiceCustomException("Order not found", "ORDER_NOT_PLACED"));

        OrderResponse orderResponse= restTemplate.getForObject("http://ORDER-SERVICE/order"+ transactionDetails.getOrderId(),OrderResponse.class);

        PaymentResponse.OrderDetails orderDetails= PaymentResponse.OrderDetails.builder()
                .orderId(orderResponse.getOrderId())
                .orderDate(orderResponse.getOrderDate())
                .orderStatus(orderResponse.getOrderStatus())
                .amount(orderResponse.getAmount())
                .build();

        PaymentResponse paymentResponse=PaymentResponse.builder()
                .id(transactionDetails.getId())
                .referenceNumber(transactionDetails.getReferenceNumber())
                .orderDetails(transactionDetails.getOrderId())
                .paymentMode()
                .build();

    }
}
