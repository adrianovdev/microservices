package com.mystore.user.controller;

import com.mystore.user.exception.UserNotFoundException;
import com.mystore.user.model.User;
import com.mystore.user.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired private UserRepository userRepository;

  @GetMapping("/")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable String id) {
    return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    user.setId(UUID.randomUUID().toString());
    return userRepository.save(user);
  }

  @PutMapping("/{id}")
  public User updateUser(@PathVariable String id, @RequestBody User user) {
    User exitingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    exitingUser.setName(user.getName());
    exitingUser.setEmail(user.getEmail());
    return userRepository.save(exitingUser);
  }
}
