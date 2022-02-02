package com.elixr.springbootapplication.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class ErrorResponses {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")

    private String success;
    private String message;

    public ErrorResponses(String success, String message) {

        this.success = success;
        this.message = message;
    }
}
