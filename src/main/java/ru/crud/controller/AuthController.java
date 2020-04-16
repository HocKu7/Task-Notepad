package ru.crud.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.crud.component.authorisation.service.AuthorisationService;
import ru.crud.component.user.dto.UserDto;

@RestController
@AllArgsConstructor
public class AuthController {

  private AuthorisationService authorisationService;

  @PostMapping("/auth/signIn")
  public UserDto singIn(@RequestBody UserDto user){
    return authorisationService.signIn(user);
  }

  @PostMapping("/auth/signUp")
  public UserDto singUp(@RequestBody UserDto user){
    return authorisationService.signUp(user);

  }
}
