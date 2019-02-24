package br.com.clinica.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Convenio {

	@JsonProperty("UNIMED")
	UNIMED, 
	@JsonProperty("SAOFRANCISCO")
	SÃOFRANCISCO,
	@JsonProperty("OUTROS")
	OUTROS;

}
