package com.transaction.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.transaction.entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
    
}