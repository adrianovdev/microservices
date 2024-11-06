package com.mystore.order.controller;

import com.mystore.order.client.UserServiceClient;
import com.mystore.order.exception.OrderNotFoundException;
import com.mystore.order.model.Order;
import com.mystore.order.model.User;
import com.mystore.order.repository.OrderRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

  @Autowired private UserServiceClient userServiceClient;
  @Autowired private OrderRepository orderRepository;

  @GetMapping("/")
  public List<Order> getAllOrders() {
    List<Order> orders = orderRepository.findAll();
    orders.forEach(
        order -> {
          User user = userServiceClient.getUserById(order.getUserId());
          order.setUser(user);
        });

    return orders;
  }

  @GetMapping("/{id}")
  public Order getOrderById(@PathVariable String id) {
    Order order = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    User user = userServiceClient.getUserById(order.getUserId());
    order.setUser(user);
    return order;
  }

  @PostMapping
  public Order createOrder(@RequestBody Order order) {
    order.setId(UUID.randomUUID().toString());
    return orderRepository.save(order);
  }
}
