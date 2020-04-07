package ru.crud.user.service;

import org.springframework.stereotype.Service;
import ru.crud.user.domain.User;
import ru.crud.user.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;

  UserServiceImpl(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public User save(User user) {
    return userRepo.save(user);
  }

  @Override
  public User findById(long id) {
    return userRepo.getById(id);
  }

  @Override
  public User update(User user) {
    return null;
  }

  @Override
  public User deleteById(User user) {
    return null;
  }
}
