package com.example.hoteldeal.controller;

import com.example.hoteldeal.model.Deal;
import com.example.hoteldeal.service.DealService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class DealController {
    @Autowired
    DealService service;

    @GetMapping(path = "/deals")
    public List<Deal> getAllDeals() {
        return service.getAllDeals();
    }

    @GetMapping(path = "/deals/{id}")
    public Optional<Deal> getDealsById(@PathVariable("id") long id) {
        return service.getDealsById(id);
    }
}