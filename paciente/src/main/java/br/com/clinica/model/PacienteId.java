package br.com.clinica.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.clinica.util.Utils;

@Embeddable
@Access(AccessType.FIELD)
public class PacienteId implements Serializable {
	private static final long serialVersionUID = -2006573754906665210L;

	public static final String ERROR_PACIENTE_ID = "PacienteId não pode ser nulo ou vazio.";

	@Column(name = "PACIENTE_ID")
	private String id;

	public PacienteId(String id) {
		setId(id);
	}

	@SuppressWarnings("unused")
	private PacienteId() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		Utils.assertArgumentNotEmpty(id, ERROR_PACIENTE_ID);
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PacienteId other = (PacienteId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClienteId [id=" + id + "]";
	}

}
