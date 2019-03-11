package br.com.clinica.model;

import java.util.Arrays;

import br.com.clinica.exception.EnumNotFound;

public enum Procedimento {

    RETORNO, CONSULTA;

    public static Procedimento nome(String procedimento) {
	return Arrays.stream(Procedimento.values()).filter(p -> p.name().equals(procedimento.toUpperCase())).findFirst()
		.orElseThrow(
			() -> new EnumNotFound("Procedimento não encontrado: " + procedimento));
    }

}
