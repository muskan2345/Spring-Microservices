package com.example.demo.OrderService.Repository;



import com.example.demo.OrderService.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface OrderRepository extends JpaRepository<Order,Long>
{



}
