package com.dailyCodeBuffer.ProductService.demo.Product.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="product")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product
{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long productId;

    @Column(name="PRODUCT_NAME")
    private String name;

    @Column(name="PRICE")
    private long price;

    @Column(name="QUANTITY")
    private long quantity;

}
