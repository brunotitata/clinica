package br.com.clinica.model;

import java.util.Arrays;

import br.com.clinica.exception.EnumNotFound;

public enum Status {
    AGENDADO, CONFIRMADO, AGUARDANDO_ATENDIMENTO, NÃO_COMPARECEU, PACIENTE_ATENDIDO, DESISTENCIA;

    public static Status capturarEnum(String status) {

	return Arrays.stream(Status.values()).filter(p -> p.name().equals(status.toUpperCase())).findFirst()
		.orElseThrow(() -> new EnumNotFound("Status não encontrado: " + status));
    }

}
