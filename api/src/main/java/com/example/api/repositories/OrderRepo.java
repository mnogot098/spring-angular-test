package com.example.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.api.models.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
