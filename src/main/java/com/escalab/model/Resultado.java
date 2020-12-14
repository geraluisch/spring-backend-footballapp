package com.escalab.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Información de resultado")
@Entity
@Table(name = "resultado")
@IdClass(ResultadoPartidoPK.class)
public class Resultado implements Serializable {
	
	private static final long serialVersionUID = 3999790306432544477L;

	@Id
	private Partido partido;
	
	@Column(name = "local", nullable = true)
	private Integer local;
	
	@Column(name = "visitante", nullable = true)
	private Integer visitante;

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	public Integer getLocal() {
		return local;
	}

	public void setLocal(Integer local) {
		this.local = local;
	}

	public Integer getVisitante() {
		return visitante;
	}

	public void setVisitante(Integer visitante) {
		this.visitante = visitante;
	}	

}
