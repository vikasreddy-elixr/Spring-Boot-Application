package com.elixr.springbootapplication.exceptionhandler;

import com.elixr.springbootapplication.constants.Constants;
import com.elixr.springbootapplication.responses.ErrorResponse;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
@NoArgsConstructor
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException exception) {
        return new ResponseEntity<>(buildErrorResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException() {
        return new ResponseEntity<>(buildErrorResponse(Constants.ERROR_BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(buildErrorResponse(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({HttpMessageNotReadableException.class, HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException() {
        return new ResponseEntity<>(buildErrorResponse(Constants.ERROR_BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedTypeException() {
        return new ResponseEntity<>(buildErrorResponse(Constants.ERROR_UNEXPECTED_TYPE), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ErrorResponse buildErrorResponse(String message) {
        return ErrorResponse.builder().success(Constants.FAILURE).message(message).build();
    }
}
