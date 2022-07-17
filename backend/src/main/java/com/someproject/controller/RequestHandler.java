package com.someproject.controller;

import com.someproject.service.ServiceMainImplInter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/")
public class RequestHandler {

    private final MainControllerAPI mainControllerAPI;
    private final ServiceMainImplInter serviceMainImplInter;

    @GetMapping("/**")
    public Object getDataGet(HttpServletRequest request) throws ServletException, IOException {
        return handleRequest(request);
    }

    @PostMapping("/**")
    public Object getDataPost(HttpServletRequest request) throws ServletException, IOException {
        return handleRequest(request);
    }

    @DeleteMapping("/**")
    public Object getDataDelete(HttpServletRequest request) throws ServletException, IOException {
        return handleRequest(request);
    }

    private Object handleRequest(HttpServletRequest request) throws ServletException, IOException {
        new MainControllerAPI(request, serviceMainImplInter);
        return mainControllerAPI.methodsDistributor();
    }
}
