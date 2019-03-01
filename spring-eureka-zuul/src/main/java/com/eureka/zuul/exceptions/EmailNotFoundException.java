package com.eureka.zuul.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmailNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2718840901424734925L;

    public EmailNotFoundException(String msg) {
        super(msg);
    }

}
