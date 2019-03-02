package br.com.clinica.model;

import java.util.Arrays;

import br.com.clinica.exception.ProcedimentoNãoEncontradoException;

public enum Procedimento {

    RETORNO, CONSULTA;

    public static Procedimento capturarValor(String procedimento) {
        return Arrays.stream(Procedimento.values())
                .filter(p -> p.name().equals(procedimento.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new ProcedimentoNãoEncontradoException(
                        "Procedimento não encontrado: " + procedimento));
    }

}
