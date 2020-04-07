package ru.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @GetMapping("/hello")
  public String welcome() {
    return "welcome";
  }

  @PostMapping("/hello")
  public String welcomePost() {
    return "welcome";
  }

}
