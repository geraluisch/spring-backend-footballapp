package com.escalab.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información de partido")
@Entity
@Table(name = "partido")
public class Partido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPartido;
	
	@ManyToOne
	@JoinColumn(name = "id_local", nullable = false, foreignKey = @ForeignKey(name = "PK_partido_equipo_local"))
	private Equipo equipoLocal;
	
	@ManyToOne
	@JoinColumn(name = "id_visitante", nullable = false, foreignKey = @ForeignKey(name = "PK_partido_equipo_visitante"))
	private Equipo equipoVisitante;
	
	@ManyToOne
	@JoinColumn(name = "id_estadio", nullable = false, foreignKey = @ForeignKey(name = "PK_partido_estadio"))
	private Estadio estadio;
	
	@Column(name = "fecha", nullable = false)
	private LocalDateTime fecha;
	
	@Column(name = "asistencia", nullable = false)
	private Integer asistencia;	

	@OneToOne(mappedBy = "partido", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private Resultado resultado;

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

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public Integer getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(Integer asistencia) {
		this.asistencia = asistencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPartido == null) ? 0 : idPartido.hashCode());
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
		Partido other = (Partido) obj;
		if (idPartido == null) {
			if (other.idPartido != null)
				return false;
		} else if (!idPartido.equals(other.idPartido))
			return false;
		return true;
	}
	
	
	
}
