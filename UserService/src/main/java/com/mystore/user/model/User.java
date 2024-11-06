package com.mystore.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class User {
  @Id private String id;
  private String name;
  private String email;
}
