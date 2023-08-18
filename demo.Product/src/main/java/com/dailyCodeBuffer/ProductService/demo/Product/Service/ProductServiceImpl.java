package com.dailyCodeBuffer.ProductService.demo.Product.Service;


import com.dailyCodeBuffer.ProductService.demo.Product.Exception.ProductServiceCustomException;
import com.dailyCodeBuffer.ProductService.demo.Product.Model.Product;
import com.dailyCodeBuffer.ProductService.demo.Product.Model.ProductRequest;
import com.dailyCodeBuffer.ProductService.demo.Product.Model.ProductResponse;
import com.dailyCodeBuffer.ProductService.demo.Product.Repository.ProductRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service

public class ProductServiceImpl implements ProductService
{

    @Autowired
    private ProductRepository productRepository;


    private static final Logger logger= LoggerFactory.getLogger(ProductService.class);

    @Override
    public long addProduct(ProductRequest productRequest) {


        
        logger.info("Adding Product");
        Product product =Product.builder().name(productRequest.getName())
                .quantity(productRequest.getQuantity()).price(productRequest.getPrice()).build();

        productRepository.save(product);
        logger.info("product Created");
        return product.getProductId();

    }

    @Override
    public ProductResponse getProductById(long productId) {


        logger.info("get Product");
        Product product = productRepository.findById(productId).orElseThrow(()->new ProductServiceCustomException("Product not found","PRODUCT_NOT_FOUND"));

        ProductResponse productResponse=new ProductResponse();
        copyProperties(product,productResponse);
        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        Product prd = productRepository.findById(productId).orElseThrow(() -> new ProductServiceCustomException("Product not found","PRODUCT_NOT_FOUND"));

        if(prd.getQuantity()<quantity){
            throw new ProductServiceCustomException("Product does not have suffiecient","INSUFFICIENT_QUANTITY");

        }
        else{
            prd.setQuantity(prd.getQuantity()-quantity);
            productRepository.save(prd);
        }

    }

    @Override
    public List<Product> getProduct() {
        List<Product> prod = productRepository.findAll();

        return prod;


    }


}
