package com.elixr.training.springboot.ExceptionHandler;

import com.elixr.training.springboot.Constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound() {
        ErrorResponse errorDetails =
                new ErrorResponse(Constants.FAILED, Constants.DATA_NOT_FOUND);
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleIllegalStateException() {
        ErrorResponse errorDetails =
                new ErrorResponse(Constants.FAILED, Constants.ARGUMENTS_NOT_FOUND);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleDeleteException() {
        ErrorResponse errorDetails =
                new ErrorResponse(Constants.FAILED, Constants.DELETE_ALL_USER);
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}

