package br.com.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.clinica.model.Paciente;
import br.com.clinica.service.PacienteService;

@RestController()
public class PacienteController {

	@Autowired
	private PacienteService pacienteService;

	@PostMapping("/salvar/paciente")
	public ResponseEntity<?> salvarPaciente(@RequestBody Paciente paciente) {

		Paciente salvarPaciente = pacienteService.salvarPaciente(paciente);

		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(salvarPaciente.getPacienteId().getId()).toUri()).build();
	}

	@GetMapping("/buscar/paciente/{pacienteId}")
	public ResponseEntity<Paciente> buscarPacientePeloId(@PathVariable String pacienteId) {

		return ResponseEntity.ok().body(pacienteService.buscarPacientePeloPacienteId(pacienteId));
	}

	@GetMapping("/buscar/pacientes/todos")
	public ResponseEntity<Page<Paciente>> buscarTodosPacientes(Pageable pageable) {

		return ResponseEntity.ok().body(pacienteService.buscarTodosPacientes(pageable));
	}

	@DeleteMapping("/excluir/paciente/{id}")
	public ResponseEntity<?> excluirPaciente(@PathVariable Long id) {

		pacienteService.excluirPaciente(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/alterar/paciente/{id}")
	public ResponseEntity<Paciente> alterarPaciente(@RequestBody Paciente obj, @PathVariable Long id) {

		pacienteService.alterarPaciente(id, obj);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/buscar/paciente/cpf/{cpf}")
	public ResponseEntity<Paciente> buscarPacientePorCpf(@PathVariable String cpf) {

		return ResponseEntity.ok().body(pacienteService.buscarPacientePorCpf(cpf));
	}
	
	@GetMapping("/buscar/paciente/nome/{nome}")
	public ResponseEntity<List<Paciente>> buscarPacientePeloNome(@PathVariable String nome) {

	        return ResponseEntity.ok().body(pacienteService.buscarPacientePorNome(nome));

	}
}
