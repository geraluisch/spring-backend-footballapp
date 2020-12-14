package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.escalab.model.Estadistica;
import com.escalab.repo.IEstadisticaRepo;
import com.escalab.service.IEstadisticaService;

@Service
public class EstadisticasServiceImpl implements IEstadisticaService {
	
	@Autowired
	private IEstadisticaRepo repo;

	@Override
	public Estadistica registrar(Estadistica obj) {
		return repo.save(obj);
	}

	@Override
	public Estadistica modificar(Estadistica obj) {
		return repo.save(obj);
	}

	@Override
	public List<Estadistica> listar() {
		return repo.findAll();
	}

	@Override
	public Estadistica leerPorId(Integer id) {
		Optional<Estadistica> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Estadistica();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public Page<Estadistica> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}	

}
