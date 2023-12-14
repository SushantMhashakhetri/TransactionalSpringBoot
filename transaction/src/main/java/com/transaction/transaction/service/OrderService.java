package com.transaction.transaction.service;

import com.transaction.transaction.dto.OrderRequest;
import com.transaction.transaction.dto.OrderResponse;

public interface OrderService  {

    OrderResponse placeOrder(OrderRequest orderReqest);
    
}
