package br.com.clinica.model;

public class Espera {

    private Long id;
    private String nome;
    private Convenio convenio;
    private String email;
    private String telefoneCelular;
    private String telefoneResidencial;

    public Espera(String nome, String telefoneCelular,
            String telefoneResidencial) {
        this.nome = nome;
        this.telefoneCelular = telefoneCelular;
        this.telefoneResidencial = telefoneResidencial;
    }

    public Espera() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Long getId() {
        return id;
    }

}
