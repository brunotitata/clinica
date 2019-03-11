package br.com.clinica.repository.spec;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.Specification;

import br.com.clinica.model.Agenda;
import br.com.clinica.model.Procedimento;
import br.com.clinica.model.Status;

public class AgendaSpecification {

    public static Specification<Agenda> dataDeAgendamentoBetween(LocalDateTime startDate, LocalDateTime endDate) {

	return (root, query, cb) -> cb.between(root.get("dataDoAgendamento"), startDate, endDate);
    }

    public static Specification<Agenda> status(Status status) {

	return (root, query, cb) -> cb.equal(root.get("status"), status);
    }

    public static Specification<Agenda> procedimento(Procedimento procedimento) {

	return (root, query, cb) -> cb.equal(root.get("procedimento"), procedimento);
    }

}
