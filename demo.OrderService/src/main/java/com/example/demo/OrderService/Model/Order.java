package com.example.demo.OrderService.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;




@Entity
@Table(name="ORDER_DETAIL")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order
{


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(name="PRODUCT_ID")
    private long productId;


    @Column(name="QUANTITY")
    private long quantity;
    @Column(name="ORDER_DATE")
    private Instant orderDate;
    @Column(name="STATUS")
    private String orderStatus;
    @Column(name="AMOUNT")
    private long amount;







}
