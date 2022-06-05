package com.someproject.configuration;

import com.someproject.Exceptions.AllExceptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AllExceptionCreateBean {

    @Bean
    public AllExceptions createBean(){
        return new AllExceptions();
    }

}
