package br.com.clinica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.clinica.model.Paciente;

@Repository
@Transactional(readOnly = true)
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    void deleteById(Long id);

    Optional<Paciente> findByCpf(String cpf);

    List<Paciente> findByNome(String nome);

}
