package com.escalab.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escalab.exception.ModeloNotFoundException;
import com.escalab.model.Estadistica;
import com.escalab.service.IEstadisticaService;

@Controller
@RequestMapping("/estadisticas")
public class EstadisticaController {
	
	@Autowired
	private IEstadisticaService service;
	
	@GetMapping
	public ResponseEntity<List<Estadistica>> listar() {
		List<Estadistica> lista = service.listar();
		return new ResponseEntity<List<Estadistica>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estadistica> listarById(@PathVariable("id") Integer id) {
		Estadistica obj = service.leerPorId(id);
		if(obj.getIdEstadistica() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		return new ResponseEntity<Estadistica>(obj, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Estadistica>> listarPageable(Pageable pageable) {
		Page<Estadistica> estadistica = service.listarPageable(pageable);
		return new ResponseEntity<Page<Estadistica>>(estadistica, HttpStatus.OK);
	} 
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Estadistica estadistica) {
		Estadistica obj = service.registrar(estadistica);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(estadistica.getIdEstadistica()).toUri();
		return ResponseEntity.created(location).build();		
	}
	
	@PutMapping
	public ResponseEntity<Estadistica> modificar(@Valid @RequestBody Estadistica estadistica) {
		Estadistica obj = service.modificar(estadistica);
		return new ResponseEntity<Estadistica>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Estadistica obj = service.leerPorId(id);
		if(obj.getIdEstadistica() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	
	

}
