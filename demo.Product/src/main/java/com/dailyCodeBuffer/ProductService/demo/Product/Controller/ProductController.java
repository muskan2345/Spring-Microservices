package com.dailyCodeBuffer.ProductService.demo.Product.Controller;


import com.dailyCodeBuffer.ProductService.demo.Product.Model.ProductRequest;
import com.dailyCodeBuffer.ProductService.demo.Product.Model.ProductResponse;
import com.dailyCodeBuffer.ProductService.demo.Product.Service.ProductService;
import com.dailyCodeBuffer.ProductService.demo.Product.Service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController
{


    @Autowired
    private ProductService productService;


    @PostMapping()
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest)
    {
        long id = productService.addProduct(productRequest);



        return new ResponseEntity<>(id, HttpStatus.CREATED);

    }

    @GetMapping("/get/{productId}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long productId){
        ProductResponse productById = productService.getProductById(productId);
        return new ResponseEntity<>(productById,HttpStatus.OK);

    }
    @PutMapping("/put/{productId}")
    public ResponseEntity<Void> reduceQuantity(@PathVariable long productId,@RequestParam long quantity){
          productService.reduceQuantity(productId,quantity);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}
