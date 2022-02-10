package com.elixr.springbootapplication.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {

    public static final String SUCCESS = "true";
    public static final String FAILURE = "false";
    public static final String ERROR_NOT_FOUND = "No record found";
    public static final String ERROR_BAD_REQUEST = "Request cannot be fulfilled due to bad syntax";
    public static final String ERROR_UNEXPECTED_TYPE = "Unexpected internal server error";
    public static final String PROMPT_PRODUCT_SUCCESSFUL_DELETION = "Purchase deleted successfully";
}
