package ru.crud.exception;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RestResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {

  @SneakyThrows
  @Override
  protected ModelAndView doResolveException(HttpServletRequest httpServletRequest,
                                            HttpServletResponse httpServletResponse, Object o, Exception e) {
    httpServletResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    return new ModelAndView();
  }
}
