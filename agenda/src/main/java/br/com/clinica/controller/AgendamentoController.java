package br.com.clinica.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.clinica.model.Agenda;
import br.com.clinica.service.AgendaService;
import br.com.clinica.service.filter.AgendaFilter;

@RestController
public class AgendamentoController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/novo")
    public ResponseEntity<?> novoAgendamento(@RequestBody Agenda agenda) {

	Agenda registrarAgenda = agendaService.registrarAgenda(agenda);

	return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
		.buildAndExpand(registrarAgenda.getId()).toUri()).build();
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<Agenda>> buscarAgendamentoPorNome(@PathVariable String nomePaciente) {

	return ResponseEntity.ok().body(agendaService.buscarAgendamentoPorNomePaciente(nomePaciente));
    }

    @GetMapping("/buscar/procedimento/{procedimento}")
    public ResponseEntity<List<Agenda>> buscarAgendamentoPorProcedimento(@PathVariable String procedimento) {

	return ResponseEntity.ok().body(agendaService.buscarAgendamentoPorProcedimento(procedimento));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarAgendamento(@PathVariable String id) {

	agendaService.deletarAgendamento(id);

	return ResponseEntity.noContent().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Agenda> editarAgendamento(@RequestBody Agenda agenda) {

	agendaService.editarAgendamento(agenda);

	return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar/consulta")
    public ResponseEntity<Page<Agenda>> consultarAgendamentoPorPeriodoEPorStatus(
	    @RequestParam(name = "startDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss") LocalDateTime startDate,
	    @RequestParam(name = "endDate", required = true) @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss") LocalDateTime endDate,
	    @RequestParam(name = "status", required = false) String status,
	    @RequestParam(name = "procedimento", required = false) String procedimento, Pageable pageable) {

	return ResponseEntity.ok().body(agendaService.buscarAgendamentoPorPeriodoEPorStatus(
		new AgendaFilter(startDate, endDate, status, procedimento, pageable)));

    }

}
