package com.elixr.springbootapplication.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class SuccessResponse {

    private String success;
    private Object purchases;
}
