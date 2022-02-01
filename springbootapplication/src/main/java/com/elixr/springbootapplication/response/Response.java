package com.elixr.springbootapplication.response;

import com.elixr.springbootapplication.contsants.Constants;
import lombok.Data;

import java.util.HashMap;

@Data
public class Response {

    private String success;
    private Object body;

    public Response(String success, Object body) {
        this.success = success;
        this.body = body;
    }

    public static HashMap<String, String> responsesForFalseForCustomException() {
        HashMap<String, String> map = new HashMap<>();
        map.put(Constants.STATUS, Constants.FAILURE);
        map.put(Constants.ERROR_MESSAGE, Constants.ERROR_DATA_NOT_FOUND);
        return map;
    }

    public static HashMap<String, String> responsesForFalseForNoSuchElementException() {
        HashMap<String, String> map = new HashMap<>();
        map.put(Constants.STATUS, Constants.FAILURE);
        map.put(Constants.ERROR_MESSAGE, Constants.ERROR_NO_SUCH_ELEMENT_FOUND);
        return map;
    }

    public static HashMap<String, String> responsesForFalseForUnExpectedTypeException() {
        HashMap<String, String> map = new HashMap<>();
        map.put(Constants.STATUS, Constants.FAILURE);
        map.put(Constants.ERROR_MESSAGE, Constants.ERROR_BAD_SYNTAX);
        return map;
    }


}

