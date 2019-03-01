package br.com.clinica.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProcedimentoNãoEncontradoException extends RuntimeException {
    private static final long serialVersionUID = -3053528923008130294L;

    public ProcedimentoNãoEncontradoException(String msg) {
        super(msg);
    }
}
