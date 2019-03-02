package br.com.clinica.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.clinica.Utils.Utils;

@Entity
@Table(name = "agenda")
public class Agenda {

    public static final String ERROR_NOME_PACIENTE = "Nome do paciente não pode ser nulo ou vazio.";
    public static final String ERROR_TELEFONE_CELULAR = "Numero do celular não pode ser nulo ou vazio.";
    public static final String ERROR_TELEFONE_RESIDENCIAL = "Numero residencial não pode ser nulo ou vazio.";
    public static final String ERROR_DATA_DO_AGENDAMENTO = "Data do agendamento não pode ser nulo ou vazio.";
    public static final String ERROR_STATUS = "Status do agendamento não pode ser nulo ou vazio.";
    public static final String ERROR_RECEPCIONISTA = "Profissional não pode ser nulo ou vazio.";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Procedimento procedimento;
    private String nomePaciente;
    @Enumerated(EnumType.STRING)
    private Recepcionista recepcionista;
    private String telefoneCelular;
    private String telefoneResidencial;
    @Enumerated(EnumType.STRING)
    private Convenio convenio;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dataDoAgendamento;
    @Enumerated(EnumType.STRING)
    private Agendamento repetirAgendamento;
    private String observacoes;
    @Enumerated(EnumType.STRING)
    private Status status;
    private BigDecimal valorAgendamento;

    public Agenda(String nomePaciente, String telefoneCelular,
            String telefoneResidencial, LocalDateTime dataDoAgendamento,
            Status status, Recepcionista recepcionista) {
        setNomePaciente(nomePaciente);
        setTelefoneCelular(telefoneCelular);
        setTelefoneResidencial(telefoneResidencial);
        setDataDoAgendamento(dataDoAgendamento);
        setStatus(status);
        setRecepcionista(recepcionista);
    }

    public Agenda() {
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        Utils.assertArgumentNotEmpty(nomePaciente, ERROR_NOME_PACIENTE);
        this.nomePaciente = nomePaciente;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        Utils.assertArgumentNotEmpty(telefoneCelular, ERROR_TELEFONE_CELULAR);
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneResidencial() {
        return telefoneResidencial;
    }

    public void setTelefoneResidencial(String telefoneResidencial) {
        Utils.assertArgumentNotEmpty(telefoneResidencial,
                ERROR_TELEFONE_RESIDENCIAL);
        this.telefoneResidencial = telefoneResidencial;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public LocalDateTime getDataDoAgendamento() {
        return dataDoAgendamento;
    }

    public void setDataDoAgendamento(LocalDateTime dataDoAgendamento) {
        Utils.assertArgumentNotNull(dataDoAgendamento,
                ERROR_DATA_DO_AGENDAMENTO);
        this.dataDoAgendamento = dataDoAgendamento;
    }

    public Agendamento getRepetirAgendamento() {
        return repetirAgendamento;
    }

    public void setRepetirAgendamento(Agendamento repetirAgendamento) {
        this.repetirAgendamento = repetirAgendamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        Utils.assertArgumentNotNull(status, ERROR_STATUS);
        this.status = status;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        Utils.assertArgumentNotNull(recepcionista, ERROR_RECEPCIONISTA);
        this.recepcionista = recepcionista;
    }

    public BigDecimal getValorAgendamento() {
        return valorAgendamento;
    }

    public void setValorAgendamento(BigDecimal valorAgendamento) {
        this.valorAgendamento = valorAgendamento;
    }

}
