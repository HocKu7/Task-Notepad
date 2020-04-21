package ru.crud.component.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.crud.component.task.domain.Task;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDto {

  private Long userId;
  private String description;
  private String status;
}