package ru.crud.component.task.service;

import ru.crud.component.task.domain.Task;
import ru.crud.component.task.dto.TaskDto;

import java.util.List;

public interface TaskService {

  List<Task> getTasksByUserId(Long id);

  Task getTaskById(Long id);

  TaskDto save(TaskDto task);

  void delete(Long id);

  TaskDto update(TaskDto task);
}
