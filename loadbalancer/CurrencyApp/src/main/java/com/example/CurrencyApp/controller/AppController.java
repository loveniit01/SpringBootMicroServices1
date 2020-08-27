package com.example.CurrencyApp.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class AppController {

@Autowired
private EurekaClient client;
@Autowired
    private RestTemplate template;

    @GetMapping("/")
    public String show()
    {
         template = getRestTemplate();
        InstanceInfo instanceInfo =  client.getNextServerFromEureka("currency-service",false);
        String currencyServiceURL = instanceInfo.getHomePageUrl();
        String exchangeMessage =  template.getForObject(currencyServiceURL, String.class);
        return  "Message is : "+exchangeMessage;
    }

    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate()
    {
        return  new RestTemplate();
    }
}
