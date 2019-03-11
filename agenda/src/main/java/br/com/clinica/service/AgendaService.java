package br.com.clinica.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.clinica.exception.AgendamentoNãoEncontradoException;
import br.com.clinica.exception.IllegalArgumentException;
import br.com.clinica.model.Agenda;
import br.com.clinica.model.PacienteResource;
import br.com.clinica.model.Procedimento;
import br.com.clinica.model.Status;
import br.com.clinica.repository.AgendaRepository;
import br.com.clinica.repository.spec.AgendaSpecification;
import br.com.clinica.service.filter.AgendaFilter;

@Service
public class AgendaService {

    public static final String urlPaciente = "http://localhost:9000/buscar/paciente/nome/";

    private RestTemplate restTemplate;
    private AgendaRepository agendaRepository;

    public AgendaService(RestTemplate restTemplate, AgendaRepository agendaRepository) {
	this.restTemplate = restTemplate;
	this.agendaRepository = agendaRepository;
    }

    public List<PacienteResource> buscarPaciente(String nome) {
	return Arrays.asList(restTemplate.getForObject(urlServicoPaciente(nome), PacienteResource[].class));
    }

    public String urlServicoPaciente(String nome) {
	return urlPaciente + nome;
    }

    public Agenda registrarAgenda(Agenda obj) {

	Agenda agenda = new Agenda(obj.getNomePaciente(), obj.getTelefoneCelular(), obj.getTelefoneResidencial(),
		obj.getDataDoAgendamento(), obj.getStatus(), obj.getRecepcionista());

	agenda.setConvenio(obj.getConvenio());
	agenda.setObservacoes(obj.getObservacoes());
	agenda.setProcedimento(obj.getProcedimento());
	agenda.setRepetirAgendamento(obj.getRepetirAgendamento());
	agenda.setValorAgendamento(obj.getValorAgendamento().setScale(2, BigDecimal.ROUND_UP));
	agenda.setObservacoes(obj.getObservacoes());

	return agendaRepository.saveAndFlush(agenda);
    }

    public List<Agenda> buscarAgendamentoPorNomePaciente(String nomePaciente) {
	return agendaRepository.findByNomePacienteContaining(nomePaciente.toUpperCase());
    }

    public List<Agenda> buscarAgendamentoPorProcedimento(String procedimento) {
	return agendaRepository.findByProcedimento(Procedimento.nome(procedimento));
    }

    public void deletarAgendamento(String id) {

	Agenda agenda = agendaRepository.findById(UUID.fromString(id)).orElseThrow(
		() -> new AgendamentoNãoEncontradoException("Não foi possivel encontrar agendamento com o id: " + id));

	agendaRepository.delete(agenda);
    }

    public Agenda editarAgendamento(Agenda obj) {

	Agenda agenda = agendaRepository.findById(obj.getId()).orElseThrow(
		() -> new IllegalArgumentException("Não foi possivel encontrar paciente com o codigo: " + obj.getId()));

	agenda.setConvenio(obj.getConvenio());
	agenda.setDataDoAgendamento(obj.getDataDoAgendamento());
	agenda.setNomePaciente(obj.getNomePaciente());
	agenda.setObservacoes(obj.getObservacoes());
	agenda.setProcedimento(obj.getProcedimento());
	agenda.setRecepcionista(obj.getRecepcionista());
	agenda.setRepetirAgendamento(obj.getRepetirAgendamento());
	agenda.setStatus(obj.getStatus());
	agenda.setTelefoneCelular(obj.getTelefoneCelular());
	agenda.setTelefoneResidencial(obj.getTelefoneResidencial());
	agenda.setValorAgendamento(obj.getValorAgendamento().setScale(2, BigDecimal.ROUND_UP));

	return agendaRepository.saveAndFlush(agenda);
    }

    public Page<Agenda> buscarAgendamentoPorPeriodoEPorStatus(AgendaFilter agendaFilter) {

	Specification<Agenda> spec = AgendaSpecification.dataDeAgendamentoBetween(agendaFilter.getStartDate(),
		agendaFilter.getEndDate());

	if (StringUtils.isNotBlank(agendaFilter.getStatus())) {
	    spec = spec.and(AgendaSpecification.status(Status.capturarEnum(agendaFilter.getStatus())));
	}

	if (StringUtils.isNotBlank(agendaFilter.getProcedimento())) {
	    spec = spec.and(AgendaSpecification.procedimento(Procedimento.nome(agendaFilter.getProcedimento())));
	}

	return agendaRepository.findAll(spec, agendaFilter.getPageable());

    }

}
