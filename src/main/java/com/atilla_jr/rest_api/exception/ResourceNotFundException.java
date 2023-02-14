package com.atilla_jr.rest_api.exception;

public class ResourceNotFundException extends RuntimeException {

  public ResourceNotFundException(Object id) {
    super("Objct not foud. id " + id);
  }
}
