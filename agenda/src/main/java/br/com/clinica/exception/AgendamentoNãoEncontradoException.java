package br.com.clinica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AgendamentoNãoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = 3586038129520869195L;

    public AgendamentoNãoEncontradoException(String msg) {
        super(msg);
    }

}
