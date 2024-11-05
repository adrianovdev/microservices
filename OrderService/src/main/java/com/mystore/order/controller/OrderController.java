package com.mystore.order.controller;

import com.mystore.order.client.UserServiceClient;
import com.mystore.order.model.Order;
import com.mystore.order.model.User;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired private UserServiceClient userServiceClient;

  @GetMapping("/{id}")
  public Order getOrderById(@PathVariable String id) {
    Order order = new Order(id, "Coffee", 1, new BigDecimal(10), "1");
    User user = userServiceClient.getUserById(order.getUserId());
    order.setUser(user);
    return order;
  }
}
