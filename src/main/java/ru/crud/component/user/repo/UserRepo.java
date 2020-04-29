package ru.crud.component.user.repo;

import ru.crud.component.user.dto.UserDto;
import ru.crud.domain.User;

import java.util.List;

public interface UserRepo {

  User getById(long id);

  List<User> getUsersByName(String name);

  void save(User user);

  void update(User user);

  void deleteById(long id);

  List<User> getAllUsers();
}
