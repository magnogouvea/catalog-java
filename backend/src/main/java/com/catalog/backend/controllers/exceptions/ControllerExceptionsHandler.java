package com.catalog.backend.controllers.exceptions;

import com.catalog.backend.services.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionsHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<StandartError> entityNotFound(EntityNotFoundException e, HttpServletRequest req) {
    StandartError err = new StandartError();
    err.setTimestamp(Instant.now());
    err.setStatus(HttpStatus.NOT_FOUND.value());
    err.setError("Resource not found");
    err.setMessage(e.getMessage());
    err.setPath(req.getRequestURI());

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }
}
