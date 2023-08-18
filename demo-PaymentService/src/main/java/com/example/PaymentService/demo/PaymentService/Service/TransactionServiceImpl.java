package com.example.PaymentService.demo.PaymentService.Service;


import com.example.PaymentService.demo.PaymentService.Entity.TransactionDetails;
import com.example.PaymentService.demo.PaymentService.Model.PaymentRequest;
import com.example.PaymentService.demo.PaymentService.Repository.PaymentRepository;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl  implements TransactionService
{


 @Autowired
 PaymentRepository paymentRepository;
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
}
