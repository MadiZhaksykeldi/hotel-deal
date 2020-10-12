package com.example.hoteldeal.dao;

import com.example.hoteldeal.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepo extends JpaRepository<Deal, Long> {

}