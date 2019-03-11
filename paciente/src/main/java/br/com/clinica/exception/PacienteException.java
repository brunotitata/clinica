package br.com.clinica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class PacienteException extends RuntimeException {

    private static final long serialVersionUID = -7197645374673103683L;

    public PacienteException(String msg) {
	super(msg);
    }
}
