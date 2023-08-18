package com.dailyCodeBuffer.ProductService.demo.Product.Repository;

import com.dailyCodeBuffer.ProductService.demo.Product.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
