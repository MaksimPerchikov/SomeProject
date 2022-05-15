package com.someproject.configuration;

import com.someproject.model.kitchen.Product;
import com.someproject.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initCook(ProductRepository productRepository){
        return args -> {
            log.info("Preloading " + productRepository
                    .save(new Product(1L, "water",10)));
            log.info("Preloading " + productRepository
                    .save(new Product(1L, "tea",7)));
            log.info("Preloading " + productRepository
                    .save(new Product(1L, "coffee",3)));
        };
    }
    /*@Bean
    CommandLineRunner initCook(MenuRepository menuRepository){
        return args -> {
            log.info("Preloading " + menuRepository
                    .save(new Menu(1L, "water",10)));
            log.info("Preloading " + menuRepository
                    .save(new Menu(1L, "tea",7)));
            log.info("Preloading " + menuRepository
                    .save(new Menu(1L, "coffee",3)));
        };
    }*/
}
