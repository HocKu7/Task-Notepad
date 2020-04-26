package ru.crud.component.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.crud.component.user.dto.UserDto;
import ru.crud.domain.User;
import ru.crud.component.user.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepo userRepo;
  private ConversionService conversionService;

  UserServiceImpl(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Autowired
  public void setConversionService(ConversionService conversionService){
    this.conversionService=conversionService;
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
    return userRepo.update(user);
  }

  @Override
  public void deleteById(long id) {
    userRepo.deleteById(id);
  }

  @Override
  public List<UserDto> getAllUser() {
    List<UserDto> usersDto = new ArrayList<>();
    List<User> users = userRepo.getAllUsers();

    for(User user:users){
      usersDto.add(conversionService.convert(user, UserDto.class));
    }
    return usersDto;
  }
}
