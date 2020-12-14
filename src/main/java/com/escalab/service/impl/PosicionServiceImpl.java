package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.escalab.model.Posicion;
import com.escalab.repo.IPosicionRepo;
import com.escalab.service.IPosicionService;

@Service
public class PosicionServiceImpl implements IPosicionService {

	@Autowired
	private IPosicionRepo repo;

	@Override
	public Posicion registrar(Posicion obj) {
		return repo.save(obj);
	}

	@Override
	public Posicion modificar(Posicion obj) {
		return repo.save(obj);
	}

	@Override
	public List<Posicion> listar() {
		return repo.findAll();
	}
	
	@Override
	public Page<Posicion> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}	
	
	@Override
	public Posicion leerPorId(Integer id) {
		Optional<Posicion> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Posicion();
	}

	@Override
	public boolean eliminar(Integer id) {	
		repo.deleteById(id);
		return true; 
	}
	
}
