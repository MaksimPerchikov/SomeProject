package com.someproject.service;

import com.someproject.Exceptions.AllExceptions;
import com.someproject.model.kitchen.Product;
import com.someproject.operations.mathOperations.OperationsOver;
import com.someproject.operations.mathOperations.VariousOperationsOverProduct;
import com.someproject.service.interfases.MainInterfaceForGiveMethods;
import com.someproject.service.operationsOver.OperationsWithRepository;
import com.someproject.verifyWords.DuplicateWordsVerify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceMainImplInter implements MainInterfaceForGiveMethods {

    private final OperationsWithRepository operations;
    private final AllExceptions allExceptions;
    private final DuplicateWordsVerify duplicateWordsVerify;

    @Autowired
    public ServiceMainImplInter(DuplicateWordsVerify duplicateWordsVerify,
                                AllExceptions allExceptions,
                                OperationsWithRepository operations
    ) {
        this.duplicateWordsVerify = duplicateWordsVerify;
        this.allExceptions = allExceptions;
        this.operations = operations;
    }

    @Override
    public String addProductService(Product product) {

        if (duplicateWordsVerify.duplicateSingleWordsName(product.getNameProduct())) {
            OperationsOver operationsOver = new VariousOperationsOverProduct(operations);
            Product productTwo = operationsOver.plusQuantity(product);
            return "Продукт с наименованием " + product.getNameProduct() + " уже имеется!"
                    + "Запасы пополнены на: " + product.getQuantityProduct()
                    .toString() + " и получилось общее количество:" + productTwo.getQuantityProduct();
        } else {
            operations.addProduct(product);
            return "Добавлен продукт в количестве: " + product.getNameProduct() + ", " + product.getQuantityProduct()
                    .toString();
        }
    }

    @Override
    public String deleteProductByIdService(Long id) {
        try {
            List<Product> productList = findAllProductsService();
            Optional<Product> optionalProduct = productList.stream()
                    .filter(elementProductDeleteById -> elementProductDeleteById.equals(new Product(id)))
                    .findFirst();
            operations.deleteByIdProduct(optionalProduct.get().getId());
            return "Добавлен продукт: " + optionalProduct.get().getNameProduct()
                    + "в количестве: " + optionalProduct.get().getQuantityProduct();
        } catch (Exception exception) {
            allExceptions.showMeExceptionWithMyMessage
                    ("Неверный id или продукт с " + id + " не найден", exception);
            return exception.getMessage();
        }
    }

    @Override
    public Product findProductByIdService(Long id) {


        Product findProduct = operations.findByIdProduct(id);
        return findProduct;
    }

    @Override
    public List<Product> findAllProductsService() {
        List<Product> productList = operations.findAllProducts();
        return productList;
    }

    @Override
    public String deleteAllProductsService() {
        List<Product> productList = operations.findAllProducts();
        operations.deleteAllProducts();
        return "Удалены все продукты: " + productList;
    }
}
