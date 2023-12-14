package com.transaction.transaction.controller;

import org.springframework.web.bind.annotation.RestController;

import com.transaction.transaction.dto.OrderRequest;
import com.transaction.transaction.dto.OrderResponse;
import com.transaction.transaction.service.OrderService;

import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

  private OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping  
  public ResponseEntity<OrderResponse> placeOrder(@RequestBody OrderRequest orderRequest) {

    return new ResponseEntity<OrderResponse>(this.orderService.placeOrder(orderRequest), HttpStatus.OK);
  }

}