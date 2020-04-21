package ru.crud.component.task.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.crud.component.converter.TaskDtoToTaskConverter;
import ru.crud.component.converter.TaskToTaskDtoConverter;
import ru.crud.component.task.domain.Task;
import ru.crud.component.task.dto.TaskDto;
import ru.crud.component.task.repo.TaskRepo;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService{

  private TaskRepo taskRepo;
  @Override
  public List<Task> getTasksByUserId(Long id) {
    return taskRepo.getTasksByUserId(id);
  }

  @Override
  public TaskDto save(TaskDto taskDto) {

    TaskDtoToTaskConverter taskDtoToTaskConverter = new TaskDtoToTaskConverter();
    Task task = taskDtoToTaskConverter.convert(taskDto);
    task.setId(new Random().nextLong()%200);

    Task returningTask=taskRepo.save(task);

    log.info("Created task with id: "+ returningTask.getId());
    TaskToTaskDtoConverter taskToTaskDtoConverter = new TaskToTaskDtoConverter();

    return taskToTaskDtoConverter.convert(returningTask);
  }

  @Override
  public void delete(Long id) {

  }

  @Override
  public TaskDto update(TaskDto task) {
    return null;
  }
}
