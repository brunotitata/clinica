package com.eureka.zuul.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IllegalRoleException extends RuntimeException {

    private static final long serialVersionUID = 2205943592462363413L;

    public IllegalRoleException(String msg) {
        super(msg);
    }

}
