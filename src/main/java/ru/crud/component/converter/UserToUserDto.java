package ru.crud.component.converter;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import ru.crud.component.user.dto.UserDto;
import ru.crud.domain.User;

public class UserToUserDto implements Converter<User, UserDto> {

  private ModelMapper modelMapper;

  public UserToUserDto(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public UserDto convert(User user) {
    return modelMapper.map(user, UserDto.class);
  }
}
