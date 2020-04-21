package ru.crud.component.converter;

import org.modelmapper.ModelMapper;
import ru.crud.component.task.domain.Task;
import ru.crud.component.task.dto.TaskDto;

public class TaskDtoToTaskConverter implements Converter<TaskDto, Task> {

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public Task convert(TaskDto taskDto) {

    Task task = new Task();
    modelMapper.map(taskDto, task);

    return task;
  }
}
