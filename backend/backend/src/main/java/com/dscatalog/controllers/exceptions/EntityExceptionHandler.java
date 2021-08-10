package com.dscatalog.controllers.exceptions;

import com.dscatalog.exceptions.DatabaseException;
import com.dscatalog.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class EntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(NotFoundException ex, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(new StandardError(
                Instant.now(),
                status.value(),
                "not found",
                ex.getMessage(),
                request.getRequestURI()
        ));
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> databaseException(DatabaseException ex, HttpServletRequest request){
        HttpStatus status = HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(status).body(new StandardError(
                Instant.now(),
                status.value(),
                "Database exception",
                ex.getMessage(),
                request.getRequestURI()
        ));
    }
}
