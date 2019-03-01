package br.com.clinica.model;

import java.math.BigDecimal;
import java.util.Arrays;

import br.com.clinica.exception.ProcedimentoNãoEncontradoException;

public enum Procedimento {

    RETORNO("Retorno", 150.00), CONSULTA("Consulta", 200.00);

    private String procedimento;
    private Double valor;

    private Procedimento(String procedimento, Double valor) {
        this.procedimento = procedimento;
        this.valor = valor;
    }

    public String getProcedimento() {
        return procedimento;
    }

    public Double getValor() {
        return valor;
    }

    public static BigDecimal valor(String procedimento) {
        return Arrays.stream(Procedimento.values())
                .filter(p -> p.getProcedimento().equals(procedimento))
                .map(m -> new BigDecimal(m.getValor())).findFirst()
                .orElseThrow(() -> new ProcedimentoNãoEncontradoException(
                        "Não foi possivel encontrar o valor do procedimento: "
                                + procedimento));
    }

}
