package com.eureka.zuul.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ExistingEmailException extends RuntimeException {
    private static final long serialVersionUID = 4354891059051722365L;

    public ExistingEmailException(String msg) {
        super(msg);
    }

}
