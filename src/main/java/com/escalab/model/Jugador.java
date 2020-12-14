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
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de jugador")
@Entity
@Table(name = "jugador")
public class Jugador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idJugador;
	
	@ManyToOne
	@JoinColumn(name = "id_equipo", nullable = false, foreignKey = @ForeignKey(name = "FK_jugador_equipo"))
	private Equipo equipo;
	
	@ManyToOne
	@JoinColumn(name = "id_posicion", nullable = false, foreignKey = @ForeignKey(name = "FK_jugador_posicion"))
	private Posicion posicion;
	
	@ApiModelProperty(notes = "El nombre debe tener como minimo 3 caracteres")
	@Size(min = 3, message = "El nombre debe tener como minimo 3 caracteres")
	@Column(name = "nombres", length = 50, nullable = false)
	private String nombres;
	
	@ApiModelProperty(notes = "El apellido debe tener como minimo 3 caracteres")
	@Size(min = 3, message = "El apellido debe tener como minimo 3 caracteres")
	@Column(name = "apellidos", length = 50, nullable = false)
	private String apellidos;
	
	@Column(name = "edad", nullable = false)
	private Integer edad;
	
	@ApiModelProperty(notes = "El pais debe tener como minimo 3 caracteres")
	@Size(min = 3, message = "El pais debe tener como minimo 3 caracteres")
	@Column(name = "pais", length = 50, nullable = false)
	private String pais;
	
	@Column(name = "numero", nullable = false)
	private Integer numero;

	public Integer getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(Integer idJugador) {
		this.idJugador = idJugador;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

}
