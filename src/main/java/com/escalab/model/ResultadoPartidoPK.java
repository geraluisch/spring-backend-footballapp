package com.escalab.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Embeddable
public class ResultadoPartidoPK implements Serializable {
	
	private static final long serialVersionUID = -2117998265173480621L;
	
	@OneToOne
	@JoinColumn(name = "id_partido", nullable = false)
	private Partido partido;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partido == null) ? 0 : partido.hashCode());
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
		ResultadoPartidoPK other = (ResultadoPartidoPK) obj;
		if (partido == null) {
			if (other.partido != null)
				return false;
		} else if (!partido.equals(other.partido))
			return false;
		return true;
	}
	
	

}
