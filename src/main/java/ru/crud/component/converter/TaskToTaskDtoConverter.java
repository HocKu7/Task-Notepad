package ru.crud.component.converter;

import org.modelmapper.ModelMapper;
import ru.crud.component.task.domain.Task;
import ru.crud.component.task.dto.TaskDto;

public class TaskToTaskDtoConverter implements Converter<Task, TaskDto> {

  private ModelMapper modelMapper = new ModelMapper();

  @Override
  public TaskDto convert(Task task) {

    TaskDto taskDto = new TaskDto();
    modelMapper.map(task, taskDto);

    return taskDto;
  }
}
