package com.elixr.training.springboot.ExceptionHandler;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Response {
    private String success;
    private Object users;

    public Response(String success, Object users) {
        this.success = success;
        this.users = users;
    }
}


