package ru.crud.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.crud.component.user.domain.User;
import ru.crud.component.user.service.UserService;

@RestController
@AllArgsConstructor
public class UserController {

  private final UserService userService;

  @DeleteMapping("/user/{id}")
  public void deleteUser(@PathVariable Long id){
    userService.deleteById(id);
  }

  @PutMapping("/user")
  public User updateUser(@RequestBody User user){
    return userService.update(user);
  }

}
