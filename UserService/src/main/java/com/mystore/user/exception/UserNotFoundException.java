package com.mystore.user.exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String id) {
    super(String.format("User %s not found", id));
  }
}
