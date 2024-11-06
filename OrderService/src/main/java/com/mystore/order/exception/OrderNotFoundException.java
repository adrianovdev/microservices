package com.mystore.order.exception;

public class OrderNotFoundException extends RuntimeException {
  public OrderNotFoundException(String id) {
    super(String.format("Order %s not found!", id));
  }
}
