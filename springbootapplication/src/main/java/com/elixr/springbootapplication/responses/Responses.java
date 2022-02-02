package com.elixr.springbootapplication.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Responses {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")

    private String success;
    private String message;
    private int code;
    private String status;
    private Object body;

    public Responses(String success, String message, HttpStatus httpStatus, Object body) {

        this.success = success;
        this.message = message;
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.body = body;
    }
}
