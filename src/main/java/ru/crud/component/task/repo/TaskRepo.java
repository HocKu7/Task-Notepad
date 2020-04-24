package ru.crud.component.task.repo;

import ru.crud.domain.Task;

import java.util.List;

public interface TaskRepo {

  List<Task> getTasksByUserId(Long id);

  Task getTaskById(Long id);

  Task save(Task task);

  void delete(Long id);

  Task update(Task task);
}
