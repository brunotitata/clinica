package br.com.clinica.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.clinica.model.Agenda;
import br.com.clinica.model.PacienteResource;
import br.com.clinica.model.Procedimento;
import br.com.clinica.repository.AgendaRepository;

@Service
public class AgendaService {

    public static final String urlPaciente = "http://localhost:9000/buscar/paciente/nome/";

    private RestTemplate restTemplate;
    private AgendaRepository agendaRepository;

    public AgendaService(RestTemplate restTemplate,
            AgendaRepository agendaRepository) {
        this.restTemplate = restTemplate;
        this.agendaRepository = agendaRepository;
    }

    public List<PacienteResource> buscarPaciente(String nome) {
        return Arrays.asList(restTemplate.getForObject(urlServicoPaciente(nome),
                PacienteResource[].class));
    }

    public String urlServicoPaciente(String nome) {
        return urlPaciente + nome;
    }

    public Agenda registrarAgenda(Agenda obj) {

        Agenda agenda = new Agenda(obj.getNomePaciente(),
                obj.getTelefoneCelular(), obj.getTelefoneResidencial(),
                obj.getDataDoAgendamento(), obj.getStatus());

        agenda.setConvenio(obj.getConvenio());
        agenda.setObservacoes(obj.getObservacoes());
        agenda.setProcedimento(obj.getProcedimento());
        agenda.setRepetirAgendamento(obj.getRepetirAgendamento());
        agenda.setValor(Procedimento.valor(obj.getProcedimento().name()));

        return agendaRepository.saveAndFlush(agenda);
    }

}
