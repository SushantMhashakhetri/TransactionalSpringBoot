package com.transaction.transaction.dto;

import com.transaction.transaction.entity.Order;
import com.transaction.transaction.entity.Payment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

    Order order;
    Payment payment;
    
}