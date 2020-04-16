package ru.crud.component.user.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.crud.component.task.domain.Task;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  private long id;
  private String name;
  private String password;
  private List<Task> tasks;
}
