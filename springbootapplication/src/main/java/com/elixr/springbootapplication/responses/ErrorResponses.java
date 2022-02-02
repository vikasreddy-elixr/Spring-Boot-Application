package com.elixr.springbootapplication.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResponses {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")

    private String success;
    private String message;
    private int code;
    private String status;

    public ErrorResponses(String success, HttpStatus httpStatus, String message) {

        this.success = success;
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }
}
