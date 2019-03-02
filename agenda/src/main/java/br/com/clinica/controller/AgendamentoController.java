package br.com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.clinica.model.Agenda;
import br.com.clinica.service.AgendaService;

@RestController
public class AgendamentoController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/novo")
    public ResponseEntity<?> novoAgendamento(@RequestBody Agenda agenda) {

        agendaService.registrarAgenda(agenda);

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequestUri()
                        .path("/{id}").buildAndExpand(agenda.getId()).toUri())
                .build();
    }

    @GetMapping("/buscar/nome/{nome}")
    public ResponseEntity<List<Agenda>> buscarAgendamentoPorNome(
            @PathVariable String nomePaciente) {

        return ResponseEntity.ok().body(
                agendaService.buscarAgendamentoPorNomePaciente(nomePaciente));
    }

    @GetMapping("/buscar/procedimento/{procedimento}")
    public ResponseEntity<List<Agenda>> buscarAgendamentoPorProcedimento(
            @PathVariable String procedimento) {

        return ResponseEntity.ok().body(
                agendaService.buscarAgendamentoPorProcedimento(procedimento));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarAgendamento(@PathVariable Long id) {
        agendaService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Agenda> editarAgendamento(
            @RequestBody Agenda agenda) {
        agendaService.editarAgendamento(agenda);
        return ResponseEntity.noContent().build();
    }

}
