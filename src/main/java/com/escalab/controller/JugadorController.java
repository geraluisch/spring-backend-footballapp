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
import com.escalab.model.Jugador;
import com.escalab.service.IJugadorService;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {
	
	@Autowired
	private IJugadorService service;
	
	@GetMapping
	public ResponseEntity<List<Jugador>> listar(){
		List<Jugador> lista = service.listar();
		return new ResponseEntity<List<Jugador>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Jugador> listaPorId(@PathVariable("id") Integer id){
		Jugador obj = service.leerPorId(id);
		if(obj.getIdJugador() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id); 
		}
		return new ResponseEntity<Jugador>(obj, HttpStatus.OK);			
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Jugador>> listarPageable(Pageable pageable) {
		Page<Jugador> jugador = service.listarPageable(pageable);
		return new ResponseEntity<Page<Jugador>>(jugador, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Jugador jugador){
		Jugador obj = service.registrar(jugador);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(jugador.getIdJugador()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Jugador> modificar(@Valid @RequestBody Jugador jugador){
		Jugador obj = service.modificar(jugador);
		return new ResponseEntity<Jugador>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id){
		Jugador obj = service.leerPorId(id);
		if(obj.getIdJugador() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	

}
