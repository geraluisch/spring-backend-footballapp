package com.escalab.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.escalab.model.Estadistica;

public interface IEstadisticaService extends ICRUD<Estadistica> {

	Page<Estadistica> listarPageable(Pageable pageable);
}
