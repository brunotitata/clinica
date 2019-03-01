package br.com.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.clinica.model.Agenda;
import br.com.clinica.service.AgendaService;

@RestController
public class AgendamentoController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/agendar")
    public ResponseEntity<?> novoAgendamento(@RequestBody Agenda agenda) {

        agendaService.registrarAgenda(agenda);

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequestUri()
                        .path("/{id}").buildAndExpand(agenda.getId()).toUri())
                .build();
    }

}
