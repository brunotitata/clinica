package br.com.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.clinica.exception.IllegalArgumentException;
import br.com.clinica.exception.PacienteException;
import br.com.clinica.model.Paciente;
import br.com.clinica.repository.PacienteRepository;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository clienteRepository) {
	this.pacienteRepository = clienteRepository;
    }

    public Paciente salvarPaciente(Paciente paciente) {

	Optional<Paciente> registroPaciente = pacienteRepository.findByCpf(paciente.getCpf());

	if (registroPaciente.isPresent()) {
	    throw new PacienteException("CPF: " + paciente.getCpf() + " já se encontra cadastrado no sistema.");
	} else {

	    Paciente novoPaciente = new Paciente(paciente.getNome(), paciente.getSexo(), paciente.getDataDeNascimento(),
		    paciente.getCpf(), paciente.getRg(), paciente.getCep(), paciente.getEndereco(),
		    paciente.getNumeroEndereco(), paciente.getBairro(), paciente.getCidade(),
		    paciente.getTelefoneCelular(), paciente.getEnviarSms(), paciente.getEnviarEmail());

	    novoPaciente.setConvenio(paciente.getConvenio());
	    novoPaciente.setEstadoCivil(paciente.getEstadoCivil());
	    novoPaciente.setNomeDaMae(paciente.getNomeDaMae());
	    novoPaciente.setNomeDoPai(paciente.getNomeDoPai());
	    novoPaciente.setTelefoneCasa(paciente.getTelefoneCasa());
	    novoPaciente.setTelefoneTrabalho(paciente.getTelefoneTrabalho());
	    novoPaciente.setEmail(paciente.getEmail());
	    novoPaciente.setComplemento(paciente.getComplemento());
	    novoPaciente.setCartaoNacionalDeSaude(paciente.getCartaoNacionalDeSaude());
	    novoPaciente.setAlergias(paciente.getAlergias());
	    novoPaciente.setPlanoDoConvenio(paciente.getPlanoDoConvenio());
	    novoPaciente.setNumeroCarteirinhaConvenio(paciente.getNumeroCarteirinhaConvenio());
	    novoPaciente.setValidadeCarteirinhaConvenio(paciente.getValidadeCarteirinhaConvenio());

	    return pacienteRepository.saveAndFlush(novoPaciente);
	}
    }

    public Paciente buscarPacientePeloPacienteId(Long id) {

	return pacienteRepository.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("Não foi possivel encontrar paciente com o ID: " + id));
    }

    public List<Paciente> buscarTodosPacientes() {

	return pacienteRepository.findAll();
    }

    public void excluirPaciente(Long id) {

	pacienteRepository.delete(pacienteRepository.findById(id).orElseThrow(
		() -> new IllegalArgumentException("Não foi possivel deletar paciente com codigo: " + id)));
    }

    public Paciente alterarPaciente(Long id, Paciente obj) {

	Paciente paciente = pacienteRepository.findById(id).orElseThrow(
		() -> new IllegalArgumentException("Não foi possivel encontrar paciente com o codigo: " + id));

	paciente.setBairro(obj.getSexo().name());
	paciente.setCartaoNacionalDeSaude(obj.getCartaoNacionalDeSaude());
	paciente.setCep(obj.getCep());
	paciente.setCidade(obj.getCidade());
	paciente.setConvenio(obj.getConvenio());
	paciente.setDataDeNascimento(obj.getDataDeNascimento());
	paciente.setEmail(obj.getEmail());
	paciente.setEndereco(obj.getEndereco());
	paciente.setEstadoCivil(obj.getEstadoCivil());
	paciente.setNome(obj.getNome());
	paciente.setNomeDaMae(obj.getNomeDaMae());
	paciente.setNomeDoPai(obj.getNomeDoPai());
	paciente.setSexo(obj.getSexo());
	paciente.setTelefoneCelular(obj.getTelefoneCelular());
	paciente.setTelefoneCasa(obj.getTelefoneCasa());
	paciente.setTelefoneTrabalho(obj.getTelefoneTrabalho());
	paciente.setEnviarSms(obj.getEnviarSms());
	paciente.setEnviarEmail(obj.getEnviarEmail());
	paciente.setComplemento(obj.getComplemento());
	paciente.setAlergias(obj.getAlergias());
	paciente.setCartaoNacionalDeSaude(obj.getCartaoNacionalDeSaude());
	paciente.setNumeroCarteirinhaConvenio(obj.getNumeroCarteirinhaConvenio());
	paciente.setValidadeCarteirinhaConvenio(obj.getValidadeCarteirinhaConvenio());
	paciente.setObservacao(obj.getObservacao());
	paciente.setNumeroEndereco(obj.getNumeroEndereco());

	return pacienteRepository.saveAndFlush(paciente);
    }

    public Paciente buscarPacientePorCpf(String cpf) {

	return pacienteRepository.findByCpf(cpf).orElseThrow(
		() -> new IllegalArgumentException("Não foi possivel encontrar paciente com o CPF: " + cpf));
    }

    public List<Paciente> buscarPacientePorNome(String nome) {

	return pacienteRepository.findByNome(nome);
    }

}
