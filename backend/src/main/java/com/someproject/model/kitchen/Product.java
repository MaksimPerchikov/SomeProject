package com.someproject.model.kitchen;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    private String nameProduct;

    private Integer quantity;
}
