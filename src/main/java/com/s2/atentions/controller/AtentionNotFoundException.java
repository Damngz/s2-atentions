package com.s2.atentions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AtentionNotFoundException extends RuntimeException {
  public AtentionNotFoundException(String message) {
    super(message);
  }
}