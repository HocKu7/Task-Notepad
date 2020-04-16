package ru.crud.user.service;

import ru.crud.user.domain.User;

public interface UserService {

  User save(User user);

  User findById(long id);

  User update(User user);

  void deleteById(long id);
}
