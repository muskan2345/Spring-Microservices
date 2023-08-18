package com.dailyCodeBuffer.ProductService.demo.Product.Service;


import com.dailyCodeBuffer.ProductService.demo.Product.Model.ProductRequest;
import com.dailyCodeBuffer.ProductService.demo.Product.Model.ProductResponse;

public interface ProductService
{

    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId,long quantity);



}
