package br.com.clinica.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EstadoCivil {

	@JsonProperty("SOLTEIRO")
	SOLTEIRO, 
	@JsonProperty("CASADO")
	CASADO, 
	@JsonProperty("DIVORCIADO")
	DIVORCIADO, 
	@JsonProperty("VIUVO")
	VIUVO;

}
