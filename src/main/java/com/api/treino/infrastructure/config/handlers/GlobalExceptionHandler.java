package com.api.treino.infrastructure.config.handlers;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.api.treino.core.domain.exceptions.NotFoundException;
import com.api.treino.infrastructure.controllers.dtos.ErrorDTOResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  protected ErrorDTOResponse handleNotFound(Exception e) {

    return new ErrorDTOResponse(HttpStatus.NOT_FOUND, e.getMessage(), null);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  protected ErrorDTOResponse handleMethodArgumentNotValid(MethodArgumentNotValidException e) {
    List<String> errors = e.getBindingResult().getFieldErrors().stream()
        .map(FieldError::getDefaultMessage).collect(Collectors.toList());
    return new ErrorDTOResponse(HttpStatus.BAD_REQUEST, e.getBody().getDetail(), errors);
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  protected ErrorDTOResponse handleError(Exception e) {
    return new ErrorDTOResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), null);
  }
}
