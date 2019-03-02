package br.com.clinica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.Agenda;
import br.com.clinica.model.Procedimento;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

    List<Agenda> findByNomePacienteContaining(String nomePaciente);

    List<Agenda> findByProcedimento(Procedimento procedimento);

    Optional<Agenda> findById(Long id);

}
