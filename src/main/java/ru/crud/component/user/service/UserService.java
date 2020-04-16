package ru.crud.component.user.service;

import ru.crud.component.user.domain.User;

public interface UserService {

  User save(User user);

  User findById(long id);

  User update(User user);

  void deleteById(long id);
}
