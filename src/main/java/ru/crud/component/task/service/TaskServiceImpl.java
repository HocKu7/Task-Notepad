package ru.crud.component.task.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.crud.component.converter.TaskDtoToTaskConverter;
import ru.crud.component.converter.TaskToTaskDtoConverter;
import ru.crud.domain.Task;
import ru.crud.component.task.dto.TaskDto;
import ru.crud.component.task.repo.TaskRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
  public Task getTaskById(Long id) {

    return taskRepo.getTaskById(id);
  }

  @Override
  public TaskDto save(TaskDto taskDto) {


    Task task = conversionService.convert(taskDto, Task.class);
    task.setId(new Random().nextLong() % 200);

    Task returningTask = taskRepo.save(task);

    log.info("Created task with id: " + returningTask.getId());

    return conversionService.convert(returningTask,TaskDto.class);
  }

  @Override
  public void delete(Long id) {

    taskRepo.delete(id);
  }

  @Override
  public TaskDto update(TaskDto task) {
    return null;
  }
}
