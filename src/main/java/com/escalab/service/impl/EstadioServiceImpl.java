package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.escalab.model.Estadio;
import com.escalab.repo.IEstadioRepo;
import com.escalab.service.IEstadioService;

@Service
public class EstadioServiceImpl implements IEstadioService {
	
	@Autowired
	private IEstadioRepo repo;

	@Override
	public Estadio registrar(Estadio obj) {
		return repo.save(obj);
	}

	@Override
	public Estadio modificar(Estadio obj) {
		return repo.save(obj);
	}

	@Override
	public List<Estadio> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Estadio> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	

	@Override
	public Estadio leerPorId(Integer id) {
		Optional<Estadio> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Estadio();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

		

}
