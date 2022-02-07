package com.elixr.springbootapplication.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ErrorResponse {

    private String success;
    private String message;
}