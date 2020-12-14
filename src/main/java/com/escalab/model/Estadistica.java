package com.escalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información de estadistica")
@Entity
@Table(name = "estadistica")
public class Estadistica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstadistica;
	
	@ManyToOne
	@JoinColumn(name = "id_partido", nullable = false, foreignKey = @ForeignKey(name = "PK_estaditica_partido"))
	private Partido partido;
	
	@ManyToOne
	@JoinColumn(name = "id_equipo", nullable = false, foreignKey = @ForeignKey(name = "PK_estaditica_equipo"))
	private Equipo equipo;
	
	@ManyToOne
	@JoinColumn(name = "id_jugador", nullable = false, foreignKey = @ForeignKey(name = "PK_estaditica_jugador"))
	private  Jugador jugador;
	
	@Column(name = "goles", nullable = false)
	private short goles;
	
	@Column(name = "asitencias", nullable = false)
	private short asistencias;
	
	@Column(name = "tarjetas_amarillas", nullable = false)
	private short tarjetasAmarillas;
	
	@Column(name = "tarjeta_roja", nullable = false)
	private boolean tarjetaRoja;
	
	@Column(name = "faltas", nullable = false)
	private short faltas;

	public Integer getIdEstadistica() {
		return idEstadistica;
	}

	public void setIdEstadistica(Integer idEstadistica) {
		this.idEstadistica = idEstadistica;
	}

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public short getGoles() {
		return goles;
	}

	public void setGoles(short goles) {
		this.goles = goles;
	}

	public short getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(short asistencias) {
		this.asistencias = asistencias;
	}

	public short getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}

	public void setTarjetasAmarillas(short tarjetasAmarillas) {
		this.tarjetasAmarillas = tarjetasAmarillas;
	}

	public boolean isTarjetaRoja() {
		return tarjetaRoja;
	}

	public void setTarjetaRoja(boolean tarjetaRoja) {
		this.tarjetaRoja = tarjetaRoja;
	}

	public short getFaltas() {
		return faltas;
	}

	public void setFaltas(short faltas) {
		this.faltas = faltas;
	}
	
}
