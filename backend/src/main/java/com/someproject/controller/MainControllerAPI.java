package com.someproject.controller;

import com.someproject.Exceptions.AllExceptions;
import com.someproject.model.kitchen.Product;
import com.someproject.service.ServiceMainImplInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component
public class MainControllerAPI {

    private final HttpServletRequest request;
    private final ServiceMainImplInter serviceMainImplInter;

    @Autowired
    public MainControllerAPI(HttpServletRequest request,
                             ServiceMainImplInter serviceMainImplInter) {
        this.request = request;
        this.serviceMainImplInter = serviceMainImplInter;
    }

    //распределитель методов
    public Object methodsDistributor() {
        String url = request.getRequestURI();
        switch (request.getMethod()) {
            case "GET":
                return receivingGetRequest(request, url);
            case "POST":
                return receivingPostRequest(request, url);
            case "DELETE":
                break;
        }
        return null;
    }

    /*получение POST запроса для /api
     *
     * */
    public Object receivingPostRequest(HttpServletRequest request, String url) {
        AllExceptions exceptions = new AllExceptions();
        String urlWithoutAPI = url.substring(5);


        return null;
    }

    /*получение GET запроса для /api
     *
     * */
    public Object receivingGetRequest(HttpServletRequest request, String url) {
        AllExceptions exceptions = new AllExceptions();
        String urlWithoutAPI = url.substring(5);
        String substringFindProductById = "findProdById";
        String substringFindAllProd = "findAllProd";
        String substringHello = "hello";

        boolean outputSubstringFindProductById = urlWithoutAPI.contains(substringFindProductById);
        if (outputSubstringFindProductById) {
            try {
                //TODO нужно вытянуть idишник для поиска продукта по id
                String idElementString = substringFindAllProd.substring(17, substringFindAllProd.length() - 1);
                Long idElement = Long.parseLong(idElementString);
                findProductByIdMethodInController(idElement);
            } catch (Exception e) {
                //TODO
                exceptions.showMeExceptionWithMyMessage("Странная ошибка", e);
            }

        }
        boolean outputSubstringHello = urlWithoutAPI.contains(substringHello);
        if (outputSubstringHello) {
            return hello();
        }
        boolean outputGetFindAllProduct = urlWithoutAPI.contains(substringFindAllProd);
        if (outputGetFindAllProduct) {
            return findAllProductMethodInController();
        }

        return null;
    }

    @PostMapping("addProduct")
    public String addProductMethod(@RequestBody Product product) {
        return serviceMainImplInter.addProductService(product);
    }

    @DeleteMapping("delProdById/{id}")
    public String deleteProductByIdMethodInController(@PathVariable("id") Long id) {
        return serviceMainImplInter.deleteProductByIdService(id);
    }

    @GetMapping("findProdById/{id}")
    public Product findProductByIdMethodInController(@PathVariable("id") Long id) {
        return serviceMainImplInter.findProductByIdService(id);
    }

    @GetMapping("findAllProd")
    public List<Product> findAllProductMethodInController() {
        return serviceMainImplInter.findAllProductsService();
    }

    @DeleteMapping("delAllProd")
    public String deleteAllProductMethodInController() {
        return serviceMainImplInter.deleteAllProductsService();
    }

    @GetMapping("hello")
    public String hello() {
        return "Hi!";
    }
}
