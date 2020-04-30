package ru.crud.component.authorisation.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import ru.crud.domain.User;
import ru.crud.component.user.dto.UserDto;
import ru.crud.component.user.repo.UserRepo;

@Service
public class AuthorisationServiceImpl implements AuthorisationService {

  private UserRepo userRepo;
  private ModelMapper modelMapper = new ModelMapper();

  public AuthorisationServiceImpl(UserRepo userRepo) {
    this.userRepo = userRepo;
  }

  @Override
  public UserDto signIn(UserDto userDto) {

    //TODO
    return null;
  }

  @Override
  public UserDto signUp(UserDto userDto) {

    User user = User.builder()
        .build();
    modelMapper.map(userDto, user);
    userRepo.save(user);
    return userDto;
  }


}
