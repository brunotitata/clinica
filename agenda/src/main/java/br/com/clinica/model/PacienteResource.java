package br.com.clinica.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PacienteResource {

    private String nome;

    @JsonProperty("telefone")
    private String telefoneCelular;

    @JsonProperty("telefone2")
    private String telefoneResidencial;

    public PacienteResource(String nome, String telefoneCelular,
            String telefoneResidencial) {
        this.nome = nome;
        this.telefoneCelular = telefoneCelular;
        this.telefoneResidencial = telefoneResidencial;
    }

    @SuppressWarnings("unused")
    private PacienteResource() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        this.telefoneResidencial = telefoneResidencial;
    }

    @Override
    public String toString() {
        return "PacienteResource [nome=" + nome + ", telefoneCelular="
                + telefoneCelular + ", telefoneResidencial="
                + telefoneResidencial + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result
                + ((telefoneCelular == null) ? 0 : telefoneCelular.hashCode());
        result = prime * result + ((telefoneResidencial == null) ? 0
                : telefoneResidencial.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PacienteResource other = (PacienteResource) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (telefoneCelular == null) {
            if (other.telefoneCelular != null)
                return false;
        } else if (!telefoneCelular.equals(other.telefoneCelular))
            return false;
        if (telefoneResidencial == null) {
            if (other.telefoneResidencial != null)
                return false;
        } else if (!telefoneResidencial.equals(other.telefoneResidencial))
            return false;
        return true;
    }

}
