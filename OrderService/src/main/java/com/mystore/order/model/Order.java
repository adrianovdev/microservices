package com.mystore.order.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "orders")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Order {
  @Id private String id;
  private String item;
  private Integer quantity;
  private BigDecimal price;
  private String userId;

  @Transient private User user;
}
