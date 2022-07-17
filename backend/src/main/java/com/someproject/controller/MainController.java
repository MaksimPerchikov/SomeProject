/*
package com.someproject.controller;

import com.someproject.model.kitchen.Product;
import com.someproject.service.ServiceMainImplInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private ServiceMainImplInter serviceMainImplInter;

    @Autowired
    public MainController(ServiceMainImplInter serviceMainImplInter) {
        this.serviceMainImplInter = serviceMainImplInter;
    }

    @PostMapping("addProduct")
    public String addProductMethod(@RequestBody Product product){
        return serviceMainImplInter.addProductService(product);
    }

    @DeleteMapping("delProdById/{id}")
    public String deleteProductByIdMethodInController(@PathVariable("id") Long id){
           return serviceMainImplInter.deleteProductByIdService(id);
    }
    @GetMapping("findProdById/{id}")
    public Product findProductByIdMethodInController(@PathVariable("id") Long id){
        return serviceMainImplInter.findProductByIdService(id);
    }

    @GetMapping("findAllProd")
    public List<Product> findAllProductMethodInController(){
        return serviceMainImplInter.findAllProductsService();
    }
    @DeleteMapping("delAllProd")
    public String deleteAllProductMethodInController(){
        return serviceMainImplInter.deleteAllProductsService();
    }

    @GetMapping("hello")
    public String hello(){
        return "Hello!";
    }
}
*/
