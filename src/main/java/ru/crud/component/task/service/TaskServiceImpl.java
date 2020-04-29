package ru.crud.component.task.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.crud.domain.Task;
import ru.crud.component.task.dto.TaskDto;
import ru.crud.component.task.repo.TaskRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

  private TaskRepo taskRepo;
  private ConversionService conversionService;

  @Override
  public List<TaskDto> getTasksByUserId(Long id) {

    List<Task> tasksByUserId = taskRepo.getTasksByUserId(id);

    return tasksByUserId.stream()
        .map(task -> conversionService.convert(task,TaskDto.class))
        .collect(Collectors.toList());
  }

  @Override
  public TaskDto getTaskById(Long id) {

    Task task = taskRepo.getTaskById(id);

    return conversionService.convert(task, TaskDto.class);
  }

  @Override
  public void save(TaskDto taskDto) {

    Task task = conversionService.convert(taskDto, Task.class);
    taskRepo.save(task);
  }

  @Override
  public void delete(Long id) {

    taskRepo.delete(id);
  }

  @Override
  public void update(TaskDto taskDto) {

    Task task = conversionService.convert(taskDto, Task.class);
    taskRepo.update(task);
  }
}
