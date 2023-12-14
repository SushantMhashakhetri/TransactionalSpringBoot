package com.transaction.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transaction.transaction.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Long>{
    
}