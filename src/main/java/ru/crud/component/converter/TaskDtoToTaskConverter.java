package ru.crud.component.converter;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import ru.crud.domain.Task;
import ru.crud.component.task.dto.TaskDto;

public class TaskDtoToTaskConverter implements Converter<TaskDto, Task> {

  private ModelMapper modelMapper;

  public TaskDtoToTaskConverter(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public Task convert(TaskDto taskDto) {

    Task task = new Task();
    modelMapper.map(taskDto, task);

    return task;
  }
}
