package com.example.demo.OrderService.Controller;


import com.example.demo.OrderService.Model.OrderRequest;
import com.example.demo.OrderService.Model.OrderResponse;
import com.example.demo.OrderService.Service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;






@RestController
@RequestMapping("/order")

public class OrderController
{


    @Autowired
    private OrderService orderService;

    private static final Logger logger= LoggerFactory.getLogger(OrderController.class);

    @PostMapping("/placeOrder")
    public ResponseEntity<Long> placeOrder( @RequestBody OrderRequest orderRequest){

        long orderId=orderService.placeOrder(orderRequest);
        logger.info("Order Id :{}",orderId);
        return new ResponseEntity<>(orderId, HttpStatus.CREATED);

    }

    @GetMapping("/getOrder/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id){

       OrderResponse orderById = orderService.getOrder(id);
        return new ResponseEntity<>(orderById,HttpStatus.OK);

    }








}
