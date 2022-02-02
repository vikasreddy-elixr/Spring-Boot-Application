package com.elixr.springbootapplication.customexceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException{

    public CustomException() {

    }
}