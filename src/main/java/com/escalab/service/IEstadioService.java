package com.escalab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.escalab.model.Estadio;

public interface IEstadioService extends ICRUD<Estadio> {
	
	Page<Estadio> listarPageable(Pageable pageable);
	
}
