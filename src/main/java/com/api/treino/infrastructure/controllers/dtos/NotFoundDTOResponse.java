package com.api.treino.infrastructure.controllers.dtos;

import org.springframework.http.HttpStatus;

public class NotFoundDTOResponse {

  private HttpStatus status;
  private String message;

  public NotFoundDTOResponse(HttpStatus status, String message) {
    this.status = status;
    this.message = message;
  }

  public HttpStatus getStatus() {
    return status;
  }

  public String getMessage() {
    return message;
  }

}
