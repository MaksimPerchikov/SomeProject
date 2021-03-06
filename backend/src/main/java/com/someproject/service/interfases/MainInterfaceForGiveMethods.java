package com.someproject.service.interfases;

import com.someproject.model.newP.Product;

import java.util.List;

public interface MainInterfaceForGiveMethods {

    String addProductService(Product product);
    String deleteProductByIdService(Long id);
    Product findProductByIdService(Long id);
    List<Product> findAllProductsService();
    String deleteAllProductsService();
}
