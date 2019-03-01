package br.com.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.clinica.model.Agenda;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
