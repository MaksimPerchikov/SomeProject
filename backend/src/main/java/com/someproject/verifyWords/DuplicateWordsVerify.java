package com.someproject.verifyWords;

import com.someproject.Exceptions.AllExceptions;
import com.someproject.model.kitchen.Product;
import com.someproject.service.operationsOver.OperationsWithRepository;
import com.someproject.verifyWords.interfaces.DuplicateWordsInterface;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DuplicateWordsVerify implements DuplicateWordsInterface {

    private final AllExceptions allExceptions;
    private final OperationsWithRepository operations;

    @Autowired
    public DuplicateWordsVerify(AllExceptions allExceptions,
        OperationsWithRepository operations){
        this.allExceptions = allExceptions;
        this.operations = operations;
    }

    //проверка на дублирующие названия одного поля. Проверка одного слова.Если переданное слово существует - true, если не существует -false
    @Override
    public boolean duplicateSingleWordsName(String word) {
        boolean duplicateSignal = false;
        try {
            List<Product> listProduct = operations.findAllProducts();
            String findDuplicateNameProduct = listProduct.stream()
                .map(Product::getNameProduct)
                .collect(Collectors.toList())
                .stream().
                filter(findName -> findName.equals(word))
                .findFirst()
                .orElse(null);

            if(findDuplicateNameProduct != null){
                duplicateSignal = true;
                return duplicateSignal;
            }
        }catch (Exception exception){
            allExceptions.showMeExceptionWithMyMessage(
                "Продукты отсутствуют ",exception
            );
        }
        return duplicateSignal;
    }

    @Override
    public boolean duplicateMultiWords(List<String> listWords) {
        return false;
    }
}
