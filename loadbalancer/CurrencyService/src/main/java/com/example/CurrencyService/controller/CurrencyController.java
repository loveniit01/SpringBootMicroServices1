package com.example.CurrencyService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CurrencyController {

    @Value("${server.port}")
    private int port;

    @GetMapping("/")
    public String show()
    {
        return "current exchange rate from port : "+port;
    }
}
