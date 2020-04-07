package ru.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.crud.user.domain.User;
import ru.crud.user.service.UserService;

@RestController
public class UserController {

  private final UserService userService;

  UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/user")
  public User getUser(Long id) {
    return userService.findById(id);
  }

  @PostMapping("/user")
  public User saveUser(User user) {
    return userService.save(user);
  }

}
