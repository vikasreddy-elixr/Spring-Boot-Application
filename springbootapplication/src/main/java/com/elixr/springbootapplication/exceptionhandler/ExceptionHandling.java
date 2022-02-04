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

import java.util.InputMismatchException;
import java.util.Objects;

@RestControllerAdvice
@NoArgsConstructor
public class ExceptionHandling {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException() {
        return new ResponseEntity<>(new ErrorResponse(Constants.FAILURE, Constants.ERROR_DATA_NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException() {
        return new ResponseEntity<>(new ErrorResponse(Constants.FAILURE, Constants.ERROR_DATA_NOT_FOUND), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, InputMismatchException.class})
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(new ErrorResponse(Constants.FAILURE, Objects.requireNonNull(exception.getFieldError()).getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException() {
        return new ResponseEntity<>(new ErrorResponse(Constants.FAILURE, Constants.ERROR_BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> HttpRequestMethodNotSupportedException() {
        return new ResponseEntity<>(new ErrorResponse(Constants.FAILURE, Constants.ERROR_BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleUnexpectedTypeException() {
        return new ResponseEntity<>(new ErrorResponse(Constants.FAILURE, Constants.ERROR_UNEXPECTED_TYPE), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
