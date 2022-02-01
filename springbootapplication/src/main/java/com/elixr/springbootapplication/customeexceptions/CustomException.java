package com.elixr.springbootapplication.customeexceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomException extends RuntimeException{

    public CustomException() {

    }
}
