package ru.crud.component.user.repo;

import ru.crud.domain.User;

public interface UserRepo {

  User getById(long id);

  User getUserByName(String name);

  User save(User user);

  User update(User user);

  void deleteById(long id);
}
