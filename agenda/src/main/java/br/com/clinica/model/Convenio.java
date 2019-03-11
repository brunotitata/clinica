package br.com.clinica.model;

import java.util.Arrays;

import br.com.clinica.exception.EnumNotFound;

public enum Convenio {

    PARTICULAR;

    public static Convenio capturarEnum(String convenio) {

	return Arrays.stream(Convenio.values()).filter(p -> p.name().equals(convenio.toUpperCase())).findFirst()
		.orElseThrow(() -> new EnumNotFound("Convenio não encontrado: " + convenio));
    }

}
