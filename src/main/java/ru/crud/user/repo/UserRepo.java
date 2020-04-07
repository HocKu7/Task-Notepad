package ru.crud.user.repo;

import ru.crud.user.domain.User;

public interface UserRepo {

  User getById(long id);

  User save(User user);

  User update(User user);

  User deleteById(long id);
}
