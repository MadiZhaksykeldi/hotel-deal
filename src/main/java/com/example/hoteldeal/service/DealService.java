package com.example.hoteldeal.service;

import com.example.hoteldeal.dao.DealRepo;
import com.example.hoteldeal.model.Deal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DealService {
    @Autowired
    DealRepo Deals;

    public List<Deal> getAllDeals() {
        return Deals.findAll();
    }

    public Optional<Deal> getDealsById(long id) {
        return Deals.findById(id);
    }
}