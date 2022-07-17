package com.someproject.operations.mathOperations;

import com.someproject.Exceptions.AllExceptions;
import com.someproject.configuration.AllExceptionCreateBean;
import com.someproject.model.newP.Product;
import com.someproject.service.operationsOver.OperationsWithRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VariousOperationsOverProduct extends OperationsOver{

    private final OperationsWithRepository operations;

    @Autowired
    public VariousOperationsOverProduct(OperationsWithRepository operations) {
        this.operations = operations;
    }

    //метод складывает все количество имеющихся данных с одного продукта с пришедим ему новым количеством
    @Override
    public Product plusQuantity(Product product){
       Product productTwo = new Product();
       AllExceptionCreateBean allExceptionCreateBean = new AllExceptionCreateBean();
       AllExceptions allExceptions  = allExceptionCreateBean.createBean();
        try {
            List<Product> productList = operations.findAllProducts();
            Optional<Product> productOperations = productList.stream()
                .filter(element -> element.getNameProduct().equals(product.getNameProduct()))
                .findFirst();

            int quantityOfFindProduct = productOperations.get().getQuantityProduct();
            int sum = quantityOfFindProduct + product.getQuantityProduct();
            productTwo.setQuantityProduct(sum);
            operations.addProduct(productTwo);

            return productTwo;

        }catch (Exception e){
            allExceptions.showMeExceptionWithMyMessage("Ошибка в методе plusQuantity. ",e);
        }
        return product;
    }
}
