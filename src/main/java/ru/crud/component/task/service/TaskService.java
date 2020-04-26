package ru.crud.component.task.service;

import ru.crud.domain.Task;
import ru.crud.component.task.dto.TaskDto;

import java.util.List;

public interface TaskService {

  List<TaskDto> getTasksByUserId(Long id);

  Task getTaskById(Long id);

  void save(TaskDto task);

  void delete(Long id);

  void update(TaskDto task);
}
