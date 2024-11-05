package com.mystore.order.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

  public Order(String id, String item, Integer quantity, BigDecimal price, String userId) {
    this.id = id;
    this.item = item;
    this.quantity = quantity;
    this.price = price;
    this.userId = userId;
  }

  private String id;
  private String item;
  private Integer quantity;
  private BigDecimal price;
  private String userId;
  private User user;
}
