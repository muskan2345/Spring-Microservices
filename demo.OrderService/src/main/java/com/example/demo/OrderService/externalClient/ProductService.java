package com.example.demo.OrderService.externalClient;


import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="PRODUCT-SERVICE/product")
@LoadBalancerClient(name = "PRODUCT-SERVICE")
public interface ProductService
{


    @PutMapping("/put/{productId}")
     ResponseEntity<Void> reduceQuantity(@PathVariable long productId, @RequestParam long quantity);

}

