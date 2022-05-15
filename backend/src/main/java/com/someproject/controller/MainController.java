package com.someproject.controller;

import com.someproject.model.kitchen.Product;
import com.someproject.service.ServiceMineImplInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MainController {

    private ServiceMineImplInter serviceMineImplInter;

    @Autowired
    public MainController(ServiceMineImplInter serviceMineImplInter) {
        this.serviceMineImplInter = serviceMineImplInter;
    }

    @PostMapping("addPr")
    public String addProductMethod(@RequestBody Product product){
        return serviceMineImplInter.addProduct(product);
    }
}
