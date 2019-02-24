package br.com.clinica.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.clinica.exception.IllegalArgumentException;
import br.com.clinica.model.Paciente;
import br.com.clinica.model.PacienteId;
import br.com.clinica.repository.PacienteRepository;
import br.com.clinica.util.Utils;

@Service
public class PacienteService {

	private PacienteRepository pacienteRepository;

	public PacienteService(PacienteRepository clienteRepository) {
		this.pacienteRepository = clienteRepository;
	}

	public Paciente salvarPaciente(Paciente paciente) {
	    
		Paciente novoPaciente = new Paciente(new PacienteId(Utils.gerarUUID()), paciente.getNome(), paciente.getSexo(), paciente.getRaca(),
				paciente.getDataDeNascimento(), paciente.getCpf(), paciente.getRg(), paciente.getCartaoNacionalDeSaude(), paciente.getCep(),
				paciente.getEndereco(), paciente.getBairro(), paciente.getCidade(), paciente.getTelefone());

		novoPaciente.setConvenio(paciente.getConvenio());
		novoPaciente.setEstadoCivil(paciente.getEstadoCivil());
		novoPaciente.setNomeDaMae(paciente.getNomeDaMae());
		novoPaciente.setNomeDoPai(paciente.getNomeDoPai());
		novoPaciente.setPlano(paciente.getPlano());
		novoPaciente.setTelefone2(paciente.getTelefone2());
		novoPaciente.setTelefone2(paciente.getTelefone3());
		novoPaciente.setEmail(paciente.getEmail());

		return pacienteRepository.saveAndFlush(novoPaciente);
	}

	public Paciente buscarPacientePeloPacienteId(String id) {

		return pacienteRepository.findByPacienteId(new PacienteId(id))
				.orElseThrow(() -> new IllegalArgumentException("Não foi possivel encontrar paciente com o ID: " + id));
	}
	
	public Page<Paciente> buscarTodosPacientes(Pageable pageable){
	    
	   return pacienteRepository.findAll(pageable);
	}
	
        public void excluirPaciente(Long id) {

        pacienteRepository.delete(pacienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(
                        "Não foi possivel deletar paciente com codigo: " + id)));
        }
        
        public Paciente alterarPaciente(Long id, Paciente obj) {
            
            Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não foi possivel encontrar paciente com o codigo: " + id));
            
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
            paciente.setPlano(obj.getPlano());
            paciente.setRaca(obj.getRaca());
            paciente.setSexo(obj.getSexo());
            paciente.setTelefone(obj.getTelefone());
            paciente.setTelefone2(obj.getTelefone2());
            paciente.setTelefone3(obj.getTelefone3());
            
            return pacienteRepository.saveAndFlush(paciente);
        }


}
