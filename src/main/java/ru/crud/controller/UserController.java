package ru.crud.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.crud.component.task.domain.Task;
import ru.crud.component.task.dto.TaskDto;
import ru.crud.component.task.service.TaskService;
import ru.crud.component.user.domain.User;
import ru.crud.component.user.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
public class UserController {

  private final UserService userService;
  private final TaskService taskService;


  @GetMapping("/user/{id}/tasks")
  public List<Task> getAllTasksByUserId(@PathVariable Long id){
    return taskService.getTasksByUserId(id);
  }

  @PostMapping("/user/tasks")
  public TaskDto createTask( @RequestBody TaskDto taskDto){

    return taskService.save(taskDto);
  }

  @DeleteMapping("/user/{id}")
  public void deleteUser(@PathVariable Long id){
    userService.deleteById(id);
  }

  @PutMapping("/user")
  public User updateUser(@RequestBody User user){
    return userService.update(user);
  }

}
