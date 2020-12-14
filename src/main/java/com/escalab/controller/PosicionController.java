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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escalab.exception.ModeloNotFoundException;
import com.escalab.model.Posicion;
import com.escalab.service.IPosicionService;

@RestController
@RequestMapping("/posiciones")
public class PosicionController {
	
	@Autowired
	private IPosicionService service;
	
	@GetMapping
	public ResponseEntity<List<Posicion>> listar() {
		List<Posicion> lista = service.listar();
		return	new ResponseEntity<List<Posicion>>(lista, HttpStatus.OK);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Posicion> listaPorId(@PathVariable("id") Integer id){
		Posicion obj = service.leerPorId(id);
		if (obj.getIdPosicion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		return new ResponseEntity<Posicion>(obj, HttpStatus.OK);		
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Posicion>> listarPageable(Pageable pageable){
		Page<Posicion> posicion = service.listarPageable(pageable);
		return new ResponseEntity<Page<Posicion>>(posicion, HttpStatus.OK);		
	}	
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Posicion posicion) {
		Posicion obj = service.registrar(posicion);		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPosicion()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Posicion> modificar(@Valid @RequestBody Posicion posicion) {
		Posicion obj = service.modificar(posicion);
		return new ResponseEntity<Posicion>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Posicion obj = service.leerPorId(id);
		if (obj.getIdPosicion() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	

}
