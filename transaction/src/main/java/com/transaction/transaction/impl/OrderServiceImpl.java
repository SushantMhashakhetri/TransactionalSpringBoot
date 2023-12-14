package com.transaction.transaction.impl;

import java.util.UUID;

import org.hibernate.annotations.SecondaryRow;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.transaction.dto.OrderRequest;
import com.transaction.transaction.dto.OrderResponse;
import com.transaction.transaction.entity.Order;
import com.transaction.transaction.entity.Payment;
import com.transaction.transaction.exception.PaymentException;
import com.transaction.transaction.repo.OrderRepo;
import com.transaction.transaction.repo.PaymentRepo;
import com.transaction.transaction.service.OrderService;

@Service
public class OrderServiceImpl  implements OrderService{

    private OrderRepo orderRepo;
    private PaymentRepo paymentRepo;

    public OrderServiceImpl(OrderRepo orderRepo, PaymentRepo paymentRepo) {
        this.orderRepo = orderRepo;
        this.paymentRepo = paymentRepo;
    }



    @Override
    // @Transactional(rollbackFor = PaymentException.class))
    @Transactional
    public OrderResponse placeOrder(OrderRequest orderReqest) {
      
       Order order = orderReqest.getOrder();
       order.setStatus("INPROGRESS");
       order.setOrderTrackingNumber(UUID.randomUUID().toString());
       orderRepo.save(order);

       Payment payment = orderReqest.getPayment();
       if(!payment.getType().equals("DEBIT")) {
        throw new PaymentException("Payment type not supported");
       }

      payment.setOrderId(order.getId());
      paymentRepo.save(payment);

      OrderResponse orderResponse = new OrderResponse();
      orderResponse.setOrderTrackingNumber(order.getOrderTrackingNumber());
      orderResponse.setStatus(order.getStatus());
      orderResponse.setMessage("SUCCESSFUL");

      return orderResponse;

    }
    
}