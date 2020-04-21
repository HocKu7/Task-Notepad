package ru.crud.component.task.repo;

import ru.crud.component.task.domain.Task;
import ru.crud.component.task.dto.TaskDto;

import java.util.List;

public interface TaskRepo {

  List<Task> getTasksByUserId(Long id);

  Task save(Task task);

  void delete(Long id);

  Task update(Task task);
}
