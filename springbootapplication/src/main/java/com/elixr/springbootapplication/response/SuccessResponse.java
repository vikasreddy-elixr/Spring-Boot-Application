package com.elixr.springbootapplication.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SuccessResponse {

    private String success;
    private Object users;
}
