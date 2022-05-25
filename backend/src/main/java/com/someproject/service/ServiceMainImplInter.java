package com.someproject.service;

import com.someproject.model.kitchen.Product;
import com.someproject.repository.CookRepository;
import com.someproject.repository.MenuRepository;
import com.someproject.repository.OrderingRepository;
import com.someproject.repository.ProductRepository;
import com.someproject.service.interfases.CookOrderingMenuProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceMainImplInter implements CookOrderingMenuProductInterface {

    private final CookRepository cookRepository;
    private final MenuRepository menuRepository;
    private final OrderingRepository orderingRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ServiceMainImplInter(CookRepository cookRepository,
                                MenuRepository menuRepository,
                                OrderingRepository orderingRepository,
                                ProductRepository productRepository) {
        this.cookRepository = cookRepository;
        this.menuRepository = menuRepository;
        this.orderingRepository = orderingRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String addProduct(Product product) {
        productRepository.save(product);
        return "Добавлен продукт в количестве: "+ product.getNameProduct()+", "+product.getQuantity().toString();
    }

    @Override
    public String deleteProductById(Long id) {
        Optional<Product> findProduct = productRepository.findById(id);
        productRepository.deleteById(id);
        return "Удален продукт в количестве: "+ findProduct.get().getNameProduct()+", "+findProduct.get().getQuantity().toString();
    }

    @Override
    public Product findProductById(Long id) {
        Optional<Product> findProduct = productRepository.findById(id);
        return findProduct.get();
    }

    @Override
    public List<Product> findAllProducts() {
       List<Product> productList  = productRepository.findAll();
       return productList;
    }

    @Override
    public String deleteAllProducts() {
        List<Product> productList  = productRepository.findAll();
        productRepository.deleteAll();
        return "Удалены все продукты: "+ productList;
    }
}
