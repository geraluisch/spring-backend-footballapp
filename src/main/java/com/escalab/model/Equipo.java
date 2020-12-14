package com.escalab.model;

import java.time.LocalDateTime;

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

@ApiModel(description = "Información del equipo")
@Entity
@Table(name = "equipo")
public class Equipo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEquipo;
	
	@ManyToOne
	@JoinColumn(name = "id_estadio", nullable = false, foreignKey = @ForeignKey(name = "FK_equipo_estadio"))
	private Estadio estadio;
	
	@ApiModelProperty(notes = "El nombre debe tener minimo 3 caracteres")
	@Size(min = 3, message = "El nombre debe tener minimo 3 caracteres")
	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;
	
	@Column(name = "fecha_fundacion")
	private LocalDateTime fechaFundacion;

	public Integer getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(Integer idEquipo) {
		this.idEquipo = idEquipo;
	}

	public Estadio getIdEstadio() {
		return estadio;
	}

	public void setIdEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFechaFundacion() {
		return fechaFundacion;
	}

	public void setFechaFundacion(LocalDateTime fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}
	
}
