package com.someproject.service.operationsOver.interfaces;

import com.someproject.model.newP.Product;

import java.util.List;

//основной интерфейс для пополнения методами класса OperationsWithRepository
public interface OperationsWithRepositoryInt {

    Product addProduct(Product product);

    Product findByIdProduct(Long id);

    List<Product> findAllProducts();

    void deleteByIdProduct(Long id);

    void deleteAllProducts();


}
