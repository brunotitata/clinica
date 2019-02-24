package br.com.clinica.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Sexo {
	
	@JsonProperty("MASCULINO")
	MASCULINO, 
	@JsonProperty("FEMININO")
	FEMININO;
}
