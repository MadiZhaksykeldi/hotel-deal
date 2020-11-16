package com.example.hoteldeal.controller;

import com.example.hoteldeal.model.Deal;
import com.example.hoteldeal.service.DealService;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class DealController {
    @Autowired
    DealService service;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping(path = "/deals")
    public List<Deal> getAllDeals() {
        return service.getAllDeals();
    }

    @HystrixCommand(fallbackMethod = "getFallbackDeal",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10"),
            }
    )
    @GetMapping(path = "/deals/{id}")
    public Optional<Deal> getDealsById(@PathVariable("id") long id) {
        return service.getDealsById(id);
    }

    public List<Deal> getFallbackDeal(@PathVariable("id") long id) {
        List<Deal> dealList = new ArrayList<>();
        dealList.add(new Deal());
        return dealList;
    }
}