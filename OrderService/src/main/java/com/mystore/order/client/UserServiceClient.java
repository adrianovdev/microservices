package com.mystore.order.client;

import com.mystore.order.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8080")
public interface UserServiceClient {

  @GetMapping("/users/{id}")
  User getUserById(@PathVariable("id") String id);
}
