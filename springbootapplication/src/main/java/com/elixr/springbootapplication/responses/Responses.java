package com.elixr.springbootapplication.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Responses {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")

    private String success;
    private Object products;

    public Responses(String success, Object products) {

        this.success = success;
        this.products = products;
    }
}
