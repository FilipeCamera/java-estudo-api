package com.api.treino.infrastructure.config.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.api.treino.core.domain.exceptions.NotFoundException;
import com.api.treino.infrastructure.controllers.dtos.NotFoundDTOResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(NotFoundException.class)
  public ResponseEntity<Object> handleError(Exception e) {

    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new NotFoundDTOResponse(HttpStatus.NOT_FOUND, e.getMessage()));
  }
}
