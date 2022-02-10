package com.elixr.springbootapplication.response;

import lombok.*;

@Data
@AllArgsConstructor
public class SuccessResponse {
    private String success;
    private Object users;
}


