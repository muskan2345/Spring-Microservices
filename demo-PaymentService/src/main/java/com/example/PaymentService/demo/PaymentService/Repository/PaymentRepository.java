package com.example.PaymentService.demo.PaymentService.Repository;

import com.example.PaymentService.demo.PaymentService.Entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository  extends JpaRepository<TransactionDetails,Long> {


}
