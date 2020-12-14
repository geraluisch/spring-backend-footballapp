package com.escalab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.escalab.model.Posicion;

public interface IPosicionService extends ICRUD<Posicion> {

	Page<Posicion> listarPageable(Pageable pageable);
	
}
