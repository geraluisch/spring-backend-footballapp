package com.escalab.dto;

public class PartidoResumenDTO {
	
	private Integer cantidad;
	private String fecha;
	
	public PartidoResumenDTO() {
		
	}
	
	public PartidoResumenDTO(Integer cantidad, String fecha) {
		super();
		this.cantidad = cantidad;
		this.fecha = fecha;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
