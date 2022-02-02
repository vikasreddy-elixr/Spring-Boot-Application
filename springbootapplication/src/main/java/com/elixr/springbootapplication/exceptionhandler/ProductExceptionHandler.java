package com.elixr.springbootapplication.exceptionhandler;

import com.elixr.springbootapplication.constants.AllConstants;
import com.elixr.springbootapplication.responses.ErrorResponses;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.UnexpectedTypeException;

@ControllerAdvice
@NoArgsConstructor
public class ProductExceptionHandler {

    @ExceptionHandler(value = {ProductNotFoundException.class})
    public ResponseEntity<ErrorResponses> handleProductNotFoundException() {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(new ErrorResponses(AllConstants.OPERATION_FAILED, AllConstants.ERROR_PRODUCT_NOT_FOUND), httpStatus);
    }

    @ExceptionHandler(value = {UnexpectedTypeException.class})
    public ResponseEntity<ErrorResponses> handleUnexpectedTypeException() {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponses(AllConstants.OPERATION_FAILED, AllConstants.ERROR_INVALID_HTTP_REQUEST), httpStatus);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ErrorResponses> handleIllegalArgumentException() {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponses(AllConstants.OPERATION_FAILED, AllConstants.ERROR_INVALID_HTTP_REQUEST), httpStatus);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponses> handleHttpMessageNotReadableException() {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponses(AllConstants.OPERATION_FAILED, AllConstants.ERROR_INVALID_HTTP_REQUEST), httpStatus);
    }

    @ExceptionHandler(value = {HttpMediaTypeNotSupportedException.class})
    public ResponseEntity<ErrorResponses> handleHttpMediaTypeNotSupportedException() {
        HttpStatus httpStatus = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
        return new ResponseEntity<>(new ErrorResponses(AllConstants.OPERATION_FAILED, AllConstants.ERROR_INVALID_HTTP_REQUEST), httpStatus);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ErrorResponses> handleOtherExceptions() {
        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        return new ResponseEntity<>(new ErrorResponses(AllConstants.OPERATION_FAILED, AllConstants.UNEXPECTED_ERROR), httpStatus);
    }
}
