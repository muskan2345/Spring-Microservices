package com.example.demo.OrderService.Service;

import com.example.demo.OrderService.Model.OrderRequest;
import com.example.demo.OrderService.Model.OrderResponse;

import javax.swing.plaf.BorderUIResource;

public interface OrderService
{

   public long placeOrder(OrderRequest orderRequest);

   public OrderResponse getOrder(long id);

}
