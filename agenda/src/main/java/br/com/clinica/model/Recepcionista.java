package br.com.clinica.model;

import java.util.Arrays;

import br.com.clinica.exception.EnumNotFound;

public enum Recepcionista {

    LEYRIANE, VIVIANE;

    public static Recepcionista capturarEnum(String recepcionista) {

	return Arrays.stream(Recepcionista.values()).filter(p -> p.name().equals(recepcionista.toUpperCase()))
		.findFirst().orElseThrow(() -> new EnumNotFound("Recepcionista não encontrado(a): " + recepcionista));
    }

}
