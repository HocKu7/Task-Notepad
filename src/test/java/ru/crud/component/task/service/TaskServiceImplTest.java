package ru.crud.component.task.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.convert.ConversionService;
import ru.crud.component.task.dto.TaskDto;
import ru.crud.component.task.repo.TaskRepo;
import ru.crud.domain.Task;
import ru.crud.domain.User;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceImplTest {

  @Mock
  private TaskRepo taskRepo;

  @Mock
  private ConversionService conversionService;

  @InjectMocks
  private TaskServiceImpl taskService;

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void getTasksByUserId() {

    long userId = 1;
    User user = User.builder()
        .id(userId)
        .name("Vasya")
        .build();
    Task task1 = Task.builder()
        .id(1L)
        .description("test1")
        .status("ok")
        .user(user)
        .build();
    Task task2 = Task.builder()
        .id(2L)
        .description("test2")
        .user(user)
        .status("ok")
        .build();
    TaskDto taskDto1 = new TaskDto(1L, "test1", "ok");
    TaskDto taskDto2 = new TaskDto(2L, "test2", "ok");

    List<Task> tasks = Arrays.asList(task1, task2);

    when(taskRepo.getTasksByUserId(userId)).thenReturn(tasks);
    when(conversionService.convert(eq(task1), eq(TaskDto.class))).thenReturn(taskDto1);
    when(conversionService.convert(eq(task2), eq(TaskDto.class))).thenReturn(taskDto2);

    List<TaskDto> actual = taskService.getTasksByUserId(userId);
    List<TaskDto> expected = Arrays.asList(taskDto1, taskDto2);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void getTaskById() {

    Long taskId = 1L;
    Task task = Task.builder()
        .id(taskId)
        .description("ok")
        .status("ok")
        .build();
    TaskDto expected = new TaskDto(taskId,"ok", "ok");
    when(taskRepo.getTaskById(taskId)).thenReturn(task);
    when(conversionService.convert(any(Task.class), eq(TaskDto.class))).thenReturn(expected);

    TaskDto actual = taskService.getTaskById(taskId);

    assertThat(actual).isEqualTo(expected);
  }

  @Test
  public void save() {

    Task task = new Task();
    when(conversionService.convert(any(TaskDto.class), eq(Task.class))).thenReturn(task);

    taskService.save(new TaskDto());

    verify(taskRepo).save(task);
  }

  @Test
  public void delete() {

    Long taskId = 1L;
    taskService.delete(taskId);
    verify(taskRepo).delete(taskId);
  }

  @Test
  public void update() {

    Task task = new Task();
    when(conversionService.convert(any(TaskDto.class), eq(Task.class))).thenReturn(task);

    taskService.update(new TaskDto());

    verify(taskRepo).update(task);
  }
}