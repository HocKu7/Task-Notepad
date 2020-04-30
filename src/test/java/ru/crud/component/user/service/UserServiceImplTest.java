package ru.crud.component.user.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;
import ru.crud.component.user.dto.UserDto;
import ru.crud.component.user.repo.UserRepo;
import ru.crud.domain.User;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

  @Mock
  private UserRepo userRepo;

  @Mock
  private ConversionService conversionService;

  private UserServiceImpl userService;

  @Before
  public void setUp() {

    MockitoAnnotations.initMocks(this);
    userService = new UserServiceImpl(userRepo);
    userService.setConversionService(conversionService);
  }

  @Test
  public void save() {

    User user = new User();
    when(conversionService.convert(any(UserDto.class), eq(User.class))).thenReturn(user);

    userService.save(new UserDto());

    verify(userRepo).save(user);
  }

  @Test
  public void findById() {

    long id = 1;
    userService.findById(id);

    verify(userRepo).getById(id);
  }

  @Test
  public void deleteById() {

    long id = 1;
    userService.deleteById(id);

    verify(userRepo).deleteById(id);
  }

  @Test
  public void getAllUser() {

    User user = User.builder()
        .id(1)
        .name("Vasya")
        .password("123")
        .build();
    UserDto userDto=new UserDto("Vasya", "123");
    List<User> users = Collections.singletonList(user);
    when(userRepo.getAllUsers()).thenReturn(users);
    when(conversionService.convert(any(User.class), eq(UserDto.class))).thenReturn(userDto);

    List<UserDto> actual = userService.getAllUser();

    List<UserDto> expected = Collections.singletonList(userDto);
    assertThat(actual).isEqualTo(expected);
  }
}