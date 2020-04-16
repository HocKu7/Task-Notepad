package ru.crud.component.task.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.crud.component.task.domain.Task;
import ru.crud.component.task.repo.TaskRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService{

  private TaskRepo taskRepo;
  @Override
  public List<Task> getTasksByUserId(Long id) {
    return taskRepo.getTasksByUserId(id);
  }
}
