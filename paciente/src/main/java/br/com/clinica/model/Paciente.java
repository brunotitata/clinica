package br.com.clinica.model;

import java.time.LocalDate;

import javax.persistence.Embedded;
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
    public static final String ERROR_RACA = "Raça não pode ser nulo ou vazio.";
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
    @Embedded
    private PacienteId pacienteId;
    private String nome;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    private Raca raca;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;
    private LocalDate dataDeNascimento;
    @CPF
    private String cpf;
    private String rg;
    private String cartaoNacionalDeSaude;
    @Enumerated(EnumType.STRING)
    private Convenio convenio;
    @Enumerated(EnumType.STRING)
    private Plano plano;
    private String cep;
    private String endereco;
    private String bairro;
    private String complemento;
    private String cidade;
    private String telefone;
    private String telefone2;
    private String telefone3;
    private String nomeDaMae;
    private String nomeDoPai;
    @Email
    private String email;
    @Enumerated(EnumType.STRING)
    private EnviarSms enviarSms;
    private String observacao;
    @Enumerated(EnumType.STRING)
    private EnviarEmail enviarEmail;

    public Paciente(PacienteId pacienteId, String nome, Sexo sexo, Raca raca,
            LocalDate dataDeNascimento, String cpf, String rg,
            String cartaoNacionalDeSaude, String cep, String endereco,
            String bairro, String cidade, String telefone, EnviarSms enviarSms,
            EnviarEmail enviarEmail) {
        setPacienteId(pacienteId);
        setNome(nome);
        setSexo(sexo);
        setRaca(raca);
        setDataDeNascimento(dataDeNascimento);
        setCpf(cpf);
        setRg(rg);
        setCartaoNacionalDeSaude(cartaoNacionalDeSaude);
        setCep(cep);
        setEndereco(endereco);
        setBairro(bairro);
        setCidade(cidade);
        setTelefone(telefone);
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

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        Utils.assertArgumentNotNull(raca, ERROR_RACA);
        this.raca = raca;
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
        Utils.assertArgumentNotEmpty(cartaoNacionalDeSaude,
                ERROR_CARTAO_NACIONAL_DE_SAUDE);
        this.cartaoNacionalDeSaude = cartaoNacionalDeSaude;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        Utils.assertArgumentNotEmpty(telefone, ERROR_TELEFONE);
        this.telefone = telefone;
    }

    public String getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(String telefone2) {
        this.telefone2 = telefone2;
    }

    public String getTelefone3() {
        return telefone3;
    }

    public void setTelefone3(String telefone3) {
        this.telefone3 = telefone3;
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

    public PacienteId getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(PacienteId pacienteId) {
        this.pacienteId = pacienteId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EnviarSms getEnviarSms() {
        return enviarSms;
    }

    public void setEnviarSms(EnviarSms enviarSms) {
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

    public EnviarEmail getEnviarEmail() {
        return enviarEmail;
    }

    public void setEnviarEmail(EnviarEmail enviarEmail) {
        this.enviarEmail = enviarEmail;
    }

}
