package ru.crud.component.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import ru.crud.component.user.dto.UserDto;
import ru.crud.domain.User;

public class UserDtoToUser implements Converter<UserDto, User> {

  private ModelMapper modelMapper;

  public UserDtoToUser(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public User convert(UserDto userDto) {
    return modelMapper.map(userDto, User.class);
  }
}
