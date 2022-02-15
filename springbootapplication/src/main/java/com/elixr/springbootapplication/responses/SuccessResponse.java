package com.elixr.springbootapplication.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessResponse {

    private String success;
    private Object data;
}


