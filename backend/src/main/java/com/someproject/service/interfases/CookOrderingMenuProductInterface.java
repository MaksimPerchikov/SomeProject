package com.someproject.service.interfases;

import com.someproject.model.kitchen.Product;

import java.util.List;

public interface CookOrderingMenuProductInterface {

    String addProduct(Product product);
    String deleteProductById(Long id);
    Product findProductById(Long id);
    List<Product> findAllProducts();
    String deleteAllProducts();
}
