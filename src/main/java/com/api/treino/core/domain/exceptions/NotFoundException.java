package com.api.treino.core.domain.exceptions;

public class NotFoundException extends Exception {

  private static final long serialVersionUID = 1L;

  public NotFoundException(String message) {
    super(message);
  }

}
