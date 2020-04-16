package ru.crud.component.task.repo;

import ru.crud.component.task.domain.Task;

import java.util.List;

public interface TaskRepo {

  List<Task> getTasksByUserId(Long id);
}
