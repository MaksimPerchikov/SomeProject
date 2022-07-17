package com.someproject.model.kitchen;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@ToString
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String nameProduct;

    private Integer quantityProduct;

    private Integer priceProduct;

    public Product() {
    }

    public Product(Long id, String nameProduct, Integer quantityProduct, Integer priceProduct) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.quantityProduct = quantityProduct;
        this.priceProduct = priceProduct;
    }

    public Product(Long id){
        this.id = id;
    }
}
