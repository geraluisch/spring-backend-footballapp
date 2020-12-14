package com.escalab.dto;

import org.springframework.hateoas.ResourceSupport;

import com.escalab.model.Equipo;
import com.escalab.model.Estadio;

public class PartidoDTO extends ResourceSupport {
	
	private Integer idPartido;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Estadio estadio;
	
	public Integer getIdPartido() {
		return idPartido;
	}
	
	public void setIdPartido(Integer idPartido) {
		this.idPartido = idPartido;
	}
	
	public Equipo getEquipoLocal() {
		return equipoLocal;
	}
	
	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}
	
	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}
	
	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}
	
	public Estadio getEstadio() {
		return estadio;
	}
	
	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}
	


}
