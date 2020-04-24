package ru.crud.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.crud.domain.Task;
import ru.crud.component.task.dto.TaskDto;
import ru.crud.component.task.service.TaskService;

import java.util.List;

@RestController("/user")
@AllArgsConstructor
public class TaskController {

  private final TaskService taskService;

  @GetMapping("/{id}/tasks")
  public List<Task> getAllTasksByUserId(@PathVariable Long id){
    return taskService.getTasksByUserId(id);
  }

  @PostMapping("/tasks")
  public TaskDto createTask(@RequestBody TaskDto taskDto){

    return taskService.save(taskDto);
  }

  @DeleteMapping("/tasks/{id}")
  @ResponseStatus(code= HttpStatus.NO_CONTENT)
  public void deleteTask(@PathVariable Long id){

    taskService.delete(id);
  }
}
