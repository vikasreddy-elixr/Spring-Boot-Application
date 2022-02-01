package com.elixr.springbootapplication.exceptionhandler;

import com.elixr.springbootapplication.customeexceptions.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

import static com.elixr.springbootapplication.response.Response.*;


@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(CustomException.class)
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

}