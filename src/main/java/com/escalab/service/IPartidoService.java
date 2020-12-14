package com.escalab.service;

import java.util.List;

import com.escalab.dto.FiltroPartidoDTO;
import com.escalab.dto.PartidoResultadoDTO;
import com.escalab.dto.PartidoResumenDTO;
import com.escalab.model.Partido;

public interface IPartidoService extends ICRUD<Partido> {
	
	Partido registrarTransaccional(PartidoResultadoDTO dto);	
		
	List<Partido> buscarFecha(FiltroPartidoDTO filtro);
	
	List<PartidoResumenDTO> listarResumen();
	
	byte[] generarReporte();

}
