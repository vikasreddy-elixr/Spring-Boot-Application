package com.elixr.training.springboot.ExceptionHandler;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
    private String success;
    private Object message;

    public ErrorResponse(String success, Object message) {
        this.success = success;
        this.message = message;
    }
}
