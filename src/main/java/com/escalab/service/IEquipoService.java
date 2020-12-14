package com.escalab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.escalab.model.Equipo;

public interface IEquipoService extends ICRUD<Equipo> {
	
	Page<Equipo> listarPageable(Pageable pageable);

}
