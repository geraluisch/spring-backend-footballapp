package com.escalab.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información del estadio")
@Entity
@Table(name = "estadio")
public class Estadio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstadio;
	
	@ApiModelProperty(notes = "El nombre del estadio debe tener minimo 3 caracteres")
	@Size(min = 3, message = "El nombre del estaido debe tener minimo 3 caracteres")
	@Column(name = "nombre", length = 45, nullable = false)
	private String nombre;
	
	@Column(name = "fecha_fundacion", nullable = false)
	private LocalDateTime fechaFundacion;

	public Integer getIdEstadio() {
		return idEstadio;
	}

	public void setIdEstadio(Integer idEstadio) {
		this.idEstadio = idEstadio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDateTime getFecha() {
		return fechaFundacion;
	}

	public void setFecha(LocalDateTime fechaFundacion) {
		this.fechaFundacion = fechaFundacion;
	}

}
