package ru.crud.component.user.service;

import ru.crud.component.user.dto.UserDto;
import ru.crud.domain.User;

import java.util.List;

public interface UserService {

  void save(User user);

  User findById(long id);

  void update(User user);

  void deleteById(long id);

  List<UserDto> getAllUser();
}
