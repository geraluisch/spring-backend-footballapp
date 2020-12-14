package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.escalab.model.Jugador;
import com.escalab.repo.IJugadorRepo;
import com.escalab.service.IJugadorService;

@Service
public class JugadorServiceImpl implements IJugadorService {

	@Autowired
	private IJugadorRepo repo;

	@Override
	public Jugador registrar(Jugador obj) {
		return repo.save(obj);
	}

	@Override
	public Jugador modificar(Jugador obj) {
		return repo.save(obj);
	}

	@Override
	public List<Jugador> listar() {
		return repo.findAll();
	}

	@Override
	public Jugador leerPorId(Integer id) {
		Optional<Jugador> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Jugador();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public Page<Jugador> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
	
	
	
	
}
