package ru.crud.component.converter;

import org.modelmapper.ModelMapper;
import org.springframework.core.convert.converter.Converter;
import ru.crud.domain.Task;
import ru.crud.component.task.dto.TaskDto;

public class TaskToTaskDtoConverter implements Converter<Task, TaskDto> {

  private ModelMapper modelMapper;

  public TaskToTaskDtoConverter(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  @Override
  public TaskDto convert(Task task) {

    TaskDto taskDto = new TaskDto();
    modelMapper.map(task, taskDto);

    return taskDto;
  }
}
