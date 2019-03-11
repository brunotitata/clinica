package br.com.clinica.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CPF;

import br.com.clinica.util.Utils;

@Entity
@Table(name = "PACIENTES")
public class Paciente {

    public static final String ERROR_NOME = "Nome não pode ser nulo ou vazio.";
    public static final String ERROR_SEXO = "Sexo não pode ser nulo ou vazio.";
    public static final String ERROR_DATA_DE_NASCIMENTO = "Data de nascimento não pode ser nulo ou vazio.";
    public static final String ERROR_CPF = "CPF não pode ser nulo ou vazio.";
    public static final String ERROR_RG = "RG não pode ser nulo ou vazio.";
    public static final String ERROR_CARTAO_NACIONAL_DE_SAUDE = "Cartão Nacional de Saude não pode ser nulo ou vazio.";
    public static final String ERROR_CEP = "Cep não pode ser nulo ou vazio.";
    public static final String ERROR_ENDERECO = "Endereco não pode ser nulo ou vazio.";
    public static final String ERROR_BAIRRO = "Bairro não pode ser nulo ou vazio.";
    public static final String ERROR_CIDADE = "Cidade não pode ser nulo ou vazio.";
    public static final String ERROR_TELEFONE = "Telefone não pode ser nulo ou vazio.";
    public static final String ERROR_ENVIO_SMS = "Envio de SMS não pode ser nulo ou vazio.";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Dados pessoais
    private String nome;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    private LocalDate dataDeNascimento;
    @CPF
    private String cpf;
    private String rg;

    // Endereco
    private String endereco;
    private Integer numeroEndereco;
    private String bairro;
    private String complemento;
    private String cep;
    private String cidade;

    // Contato
    private String telefoneCelular;
    private String telefoneCasa;
    private String telefoneTrabalho;
    private String nomeDaMae;
    private String nomeDoPai;
    @Email
    private String email;
    private Boolean enviarSms;
    private Boolean enviarEmail;

    // Outros
    private String observacao;
    private String alergias;

    // Convenio
    private String cartaoNacionalDeSaude;
    @Enumerated(EnumType.STRING)
    private Convenio convenio;
    private String planoDoConvenio;
    private String numeroCarteirinhaConvenio;
    private LocalDate validadeCarteirinhaConvenio;

    public Paciente(String nome, Sexo sexo, LocalDate dataDeNascimento, String cpf, String rg, String cep,
	    String endereco, Integer numeroEndereco, String bairro, String cidade, String telefoneCelular,
	    Boolean enviarSms, Boolean enviarEmail) {
	setNome(nome);
	setSexo(sexo);
	setDataDeNascimento(dataDeNascimento);
	setCpf(cpf);
	setRg(rg);
	setCep(cep);
	setEndereco(endereco);
	setNumeroEndereco(numeroEndereco);
	setBairro(bairro);
	setCidade(cidade);
	setTelefoneCelular(telefoneCelular);
	setEnviarSms(enviarSms);
	setEnviarEmail(enviarEmail);
    }

    public Paciente() {
    }

    public String getNome() {
	return nome;
    }

    public void setNome(String nome) {
	Utils.assertArgumentNotEmpty(nome, ERROR_NOME);
	this.nome = nome;
    }

    public Sexo getSexo() {
	return sexo;
    }

    public void setSexo(Sexo sexo) {
	Utils.assertArgumentNotNull(sexo, ERROR_SEXO);
	this.sexo = sexo;
    }

    public EstadoCivil getEstadoCivil() {
	return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
	this.estadoCivil = estadoCivil;
    }

    public LocalDate getDataDeNascimento() {
	return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
	Utils.assertArgumentNotNull(dataDeNascimento, ERROR_DATA_DE_NASCIMENTO);
	this.dataDeNascimento = dataDeNascimento;
    }

    public String getCpf() {
	return cpf;
    }

    public void setCpf(String cpf) {
	Utils.assertArgumentNotEmpty(cpf, ERROR_CPF);
	this.cpf = cpf;
    }

    public String getRg() {
	return rg;
    }

    public void setRg(String rg) {
	Utils.assertArgumentNotEmpty(rg, ERROR_RG);
	this.rg = rg;
    }

    public String getCartaoNacionalDeSaude() {
	return cartaoNacionalDeSaude;
    }

    public void setCartaoNacionalDeSaude(String cartaoNacionalDeSaude) {
	this.cartaoNacionalDeSaude = cartaoNacionalDeSaude;
    }

    public Convenio getConvenio() {
	return convenio;
    }

    public void setConvenio(Convenio convenio) {
	this.convenio = convenio;
    }

    public String getCep() {
	return cep;
    }

    public void setCep(String cep) {
	Utils.assertArgumentNotEmpty(cep, ERROR_CEP);
	this.cep = cep;
    }

    public String getEndereco() {
	return endereco;
    }

    public void setEndereco(String endereco) {
	Utils.assertArgumentNotEmpty(endereco, ERROR_ENDERECO);
	this.endereco = endereco;
    }

    public String getBairro() {
	return bairro;
    }

    public void setBairro(String bairro) {
	Utils.assertArgumentNotEmpty(bairro, ERROR_BAIRRO);
	this.bairro = bairro;
    }

    public String getCidade() {
	return cidade;
    }

    public void setCidade(String cidade) {
	Utils.assertArgumentNotEmpty(cidade, ERROR_CIDADE);
	this.cidade = cidade;
    }

    public String getNomeDaMae() {
	return nomeDaMae;
    }

    public void setNomeDaMae(String nomeDaMae) {
	this.nomeDaMae = nomeDaMae;
    }

    public String getNomeDoPai() {
	return nomeDoPai;
    }

    public void setNomeDoPai(String nomeDoPai) {
	this.nomeDoPai = nomeDoPai;
    }

    public Long getId() {
	return id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Boolean getEnviarSms() {
	return enviarSms;
    }

    public void setEnviarSms(Boolean enviarSms) {
	Utils.assertArgumentNotNull(enviarSms, ERROR_ENVIO_SMS);
	this.enviarSms = enviarSms;
    }

    public String getObservacao() {
	return observacao;
    }

    public void setObservacao(String observacao) {
	this.observacao = observacao;
    }

    public String getComplemento() {
	return complemento;
    }

    public void setComplemento(String complemento) {
	this.complemento = complemento;
    }

    public Boolean getEnviarEmail() {
	return enviarEmail;
    }

    public void setEnviarEmail(Boolean enviarEmail) {
	this.enviarEmail = enviarEmail;
    }

    public Integer getNumeroEndereco() {
	return numeroEndereco;
    }

    public void setNumeroEndereco(Integer numeroEndereco) {
	this.numeroEndereco = numeroEndereco;
    }

    public String getTelefoneCelular() {
	return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
	this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneCasa() {
	return telefoneCasa;
    }

    public void setTelefoneCasa(String telefoneCasa) {
	this.telefoneCasa = telefoneCasa;
    }

    public String getTelefoneTrabalho() {
	return telefoneTrabalho;
    }

    public void setTelefoneTrabalho(String telefoneTrabalho) {
	this.telefoneTrabalho = telefoneTrabalho;
    }

    public String getAlergias() {
	return alergias;
    }

    public void setAlergias(String alergias) {
	this.alergias = alergias;
    }

    public String getPlanoDoConvenio() {
	return planoDoConvenio;
    }

    public void setPlanoDoConvenio(String planoDoConvenio) {
	this.planoDoConvenio = planoDoConvenio;
    }

    public String getNumeroCarteirinhaConvenio() {
	return numeroCarteirinhaConvenio;
    }

    public void setNumeroCarteirinhaConvenio(String numeroCarteirinhaConvenio) {
	this.numeroCarteirinhaConvenio = numeroCarteirinhaConvenio;
    }

    public LocalDate getValidadeCarteirinhaConvenio() {
	return validadeCarteirinhaConvenio;
    }

    public void setValidadeCarteirinhaConvenio(LocalDate validadeCarteirinhaConvenio) {
	this.validadeCarteirinhaConvenio = validadeCarteirinhaConvenio;
    }

}
