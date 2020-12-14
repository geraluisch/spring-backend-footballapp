package com.escalab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.escalab.model.Jugador;

public interface IJugadorService extends ICRUD<Jugador> {

	Page<Jugador> listarPageable(Pageable pageable);
	
}
