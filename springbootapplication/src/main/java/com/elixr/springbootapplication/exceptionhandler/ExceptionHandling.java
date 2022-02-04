package com.elixr.springbootapplication.exceptionhandler;

import com.elixr.springbootapplication.customexceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;
import static com.elixr.springbootapplication.response.Response.responsesForFalseForCustomException;
import static com.elixr.springbootapplication.response.Response.responsesForFalseForNoSuchElementException;
import static com.elixr.springbootapplication.response.Response.responsesForFalseForUnExpectedTypeException;

@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> noSuchDataException() {
        return new ResponseEntity<>(responsesForFalseForCustomException(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> noSuchElementException() {
        return new ResponseEntity<>(responsesForFalseForNoSuchElementException(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> unExpectedTypeException() {
        return new ResponseEntity<>(responsesForFalseForUnExpectedTypeException(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<?> bindException() {
        return new ResponseEntity<>(responsesForFalseForUnExpectedTypeException(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> HttpRequestMethodNotSupportedException() {
        return new ResponseEntity<>(responsesForFalseForUnExpectedTypeException(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> HttpMessageNotReadableException() {
        return new ResponseEntity<>(responsesForFalseForUnExpectedTypeException(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> IllegalArgumentException() {
        return new ResponseEntity<>(responsesForFalseForUnExpectedTypeException(), HttpStatus.BAD_REQUEST);
    }
}