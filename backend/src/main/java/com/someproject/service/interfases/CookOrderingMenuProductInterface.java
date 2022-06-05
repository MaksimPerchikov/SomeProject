package com.someproject.service.interfases;

import com.someproject.model.kitchen.Product;

import java.util.List;

public interface CookOrderingMenuProductInterface {

    String addProductService(Product product);
    String deleteProductByIdService(Long id);
    Product findProductByIdService(Long id);
    List<Product> findAllProductsService();
    String deleteAllProductsService();
}
