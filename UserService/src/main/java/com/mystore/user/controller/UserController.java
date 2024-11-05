package com.mystore.user.controller;

import com.mystore.user.model.User;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  private final Map<String, User> users = new HashMap<>();

  public UserController() {
    users.put("1", new User("1", "John Wick", "john@kill.io"));
    users.put("2", new User("1", "Ethan Hunt", "ethan@impossible.io"));
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable String id) {
    return users.get(id);
  }
}
