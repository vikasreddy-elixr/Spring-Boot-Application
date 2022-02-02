package com.elixr.springbootapplication.constants;

import org.springframework.stereotype.Component;

@Component
public class AllConstants {

    public static final String OPERATION_SUCCESS = "true";
    public static final String OPERATION_FAILED = "false";
    public static final String ERROR_INVALID_HTTP_REQUEST = "Request body has incorrect syntax";
    public static final String ERROR_PRODUCT_NOT_FOUND = "Product not found";
    public static final String UNEXPECTED_ERROR = "Unexpected error";
}
