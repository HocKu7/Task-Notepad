package ru.crud.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.crud.component.authorisation.service.AuthorisationService;
import ru.crud.component.user.dto.UserDto;


@RestController
@AllArgsConstructor
public class AuthController {

  private AuthorisationService authorisationService;

  @PostMapping("/auth/signIn")
  @ResponseStatus(HttpStatus.OK)
  public void singIn(@RequestBody UserDto user){
    authorisationService.signIn(user);
  }

  @PostMapping("/auth/signUp")
  @ResponseStatus(HttpStatus.CREATED)
  public void singUp(@RequestBody UserDto user){
    authorisationService.signUp(user);
  }
}
