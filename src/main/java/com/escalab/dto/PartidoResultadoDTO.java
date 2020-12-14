package com.escalab.dto;

import com.escalab.model.Partido;
import com.escalab.model.Resultado;

public class PartidoResultadoDTO {
	
	private Partido partido;
	private Resultado resultado;
	
	public Partido getPartido() {
		return partido;
	}
	
	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	public Resultado getResultado() {
		return resultado;
	}
	
	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

}
