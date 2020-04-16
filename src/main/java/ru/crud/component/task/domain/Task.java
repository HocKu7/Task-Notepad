package ru.crud.component.task.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task {

  private Long id;
  private Long userId;
  private String description;
  private String status;
}
