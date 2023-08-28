package br.com.vithorfjm.projectmanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDTO> entityNotFound(EntityNotFoundException e) {
        ExceptionDTO err = new ExceptionDTO();
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ExceptionDTO> dataTimeParseError() {
        ExceptionDTO err = new ExceptionDTO();
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setMessage("Invalid date format. Please provide a valid date in the format 'YYYY-MM-DD");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
