package ru.crud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.crud.component.converter.TaskDtoToTaskConverter;
import ru.crud.component.converter.TaskToTaskDtoConverter;
import ru.crud.component.converter.UserDtoToUser;
import ru.crud.component.converter.UserToUserDto;

@EnableWebMvc
@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("swagger-ui.html")
        .addResourceLocations("classpath:/META-INF/resources/");

    registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/");
  }

  @Override
  public void addFormatters(FormatterRegistry registry) {

    ModelMapper modelMapper = new ModelMapper();
    registry.addConverter(new TaskDtoToTaskConverter(modelMapper));
    registry.addConverter(new TaskToTaskDtoConverter(modelMapper));
    registry.addConverter(new UserDtoToUser(modelMapper));
    registry.addConverter(new UserToUserDto(modelMapper));
  }
}
