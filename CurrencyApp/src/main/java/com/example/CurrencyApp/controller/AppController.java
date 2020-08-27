package com.example.CurrencyApp.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {
@Autowired
EurekaClient eurekaClient;
@Autowired
    RestTemplate template;

    @GetMapping("/")
    public String show()
    {
         template = new RestTemplate();
        InstanceInfo instanceInfo =  eurekaClient.getNextServerFromEureka()
        return  template.toString();
    }
}
