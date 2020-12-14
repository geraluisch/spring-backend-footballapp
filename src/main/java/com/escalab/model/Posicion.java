package com.escalab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Información de posicion")
@Entity
@Table(name = "posicion")
public class Posicion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPosicion;
	
	@ApiModelProperty(notes = "La descripción debe tener como minito 3 caracteres")
	@Size(min = 3, message = "La descripción debe tener como minito 3 caracteres")
	@Column(name = "descripcion", length = 45, nullable = false)
	private String descripcion;

	public Integer getIdPosicion() {
		return idPosicion;
	}

	public void setIdPosicion(Integer idPosicion) {
		this.idPosicion = idPosicion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
