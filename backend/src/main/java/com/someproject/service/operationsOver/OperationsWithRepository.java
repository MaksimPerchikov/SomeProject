package com.someproject.service.operationsOver;

import com.someproject.model.kitchen.Product;
import com.someproject.repository.ProductRepository;
import com.someproject.service.operationsOver.interfaces.OperationsWithRepositoryInt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service//основной класс для взаимодействия с базой.
public class OperationsWithRepository implements OperationsWithRepositoryInt {

    private ProductRepository productRepository;
    /*private OrderingRepository orderingRepository;
    private MenuRepository menuRepository;
    private CookRepository cookRepository;*/

    @Autowired
    public OperationsWithRepository(ProductRepository productRepository/*,
                                    OrderingRepository orderingRepository,
                                    MenuRepository menuRepository,
                                    CookRepository cookRepository*/) {
        this.productRepository = productRepository;
        /*this.orderingRepository = orderingRepository;
        this.menuRepository = menuRepository;
        this.cookRepository = cookRepository;*/
    }


    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findByIdProduct(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void deleteByIdProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}
