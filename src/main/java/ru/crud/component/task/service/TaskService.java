package ru.crud.component.task.service;

import ru.crud.component.task.domain.Task;

import java.util.List;

public interface TaskService {

  List<Task> getTasksByUserId(Long id);
}
