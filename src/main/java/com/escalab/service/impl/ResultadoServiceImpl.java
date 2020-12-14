package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.escalab.model.Resultado;
import com.escalab.repo.IResultadoRepo;
import com.escalab.service.IResultadoService;

@Service
public class ResultadoServiceImpl implements IResultadoService {

	@Autowired
	private IResultadoRepo repo;
	
	@Override
	public Resultado registrar(Resultado obj) {
		return repo.save(obj);
	}

	@Override
	public Resultado modificar(Resultado obj) {
		return repo.save(obj);
	}

	@Override
	public List<Resultado> listar() {
		return repo.findAll();
	}

	@Override
	public Resultado leerPorId(Integer id) {
		Optional<Resultado> op = repo.findById(id); 
		return op.isPresent() ? op.get() : new Resultado();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

}
