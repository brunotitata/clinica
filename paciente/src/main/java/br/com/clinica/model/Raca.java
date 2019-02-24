package br.com.clinica.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Raca {

	@JsonProperty("BRANCA")
	BRANCA, 
	@JsonProperty("NEGRA")
	NEGRA,
	@JsonProperty("PARDO")
	PARDO, 
	@JsonProperty("MISTICA")
	MISTICA;

}
