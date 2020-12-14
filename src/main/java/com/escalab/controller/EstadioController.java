package com.escalab.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escalab.exception.ModeloNotFoundException;
import com.escalab.model.Estadio;
import com.escalab.service.IEstadioService;

@RestController
@RequestMapping("/estadios")
public class EstadioController {
	
	@Autowired
	private IEstadioService service;
	
	@GetMapping
	public ResponseEntity<List<Estadio>> listar(){
		List<Estadio> lista = service.listar();
		return new ResponseEntity<List<Estadio>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estadio> listaPorId(@PathVariable("id") Integer id){
		Estadio obj = service.leerPorId(id);
		if(obj.getIdEstadio() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id); 
		}
		return new ResponseEntity<Estadio>(obj, HttpStatus.OK);			
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Estadio>> listarPageable(Pageable pageable) {
		Page<Estadio> estadio = service.listarPageable(pageable);
		return new ResponseEntity<Page<Estadio>>(estadio, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Estadio estadio){
		Estadio obj = service.registrar(estadio);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estadio.getIdEstadio()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Estadio> modificar(@Valid @RequestBody Estadio estadio){
		Estadio obj = service.modificar(estadio);
		return new ResponseEntity<Estadio>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Estadio obj = service.leerPorId(id);
		if(obj.getIdEstadio() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	

}
