package com.escalab.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.escalab.dto.FiltroPartidoDTO;
import com.escalab.dto.PartidoDTO;
import com.escalab.dto.PartidoResultadoDTO;
import com.escalab.dto.PartidoResumenDTO;
import com.escalab.exception.ModeloNotFoundException;
import com.escalab.model.Archivo;
import com.escalab.model.Partido;
import com.escalab.service.IArchivoService;
import com.escalab.service.IPartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
	
	@Autowired
	private IPartidoService service;	
	
	@GetMapping
	public ResponseEntity<List<Partido>> listar() {
		List<Partido> lista = service.listar();
		return new ResponseEntity<List<Partido>>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Partido> listarPorId(@PathVariable("id") Integer id) {
		Partido obj = service.leerPorId(id);
		if(obj.getIdPartido() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		return new ResponseEntity<Partido>(obj, HttpStatus.OK);
	}
	
	@GetMapping(value = "/hateoas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PartidoDTO> listarHateoas() {
		List<Partido> partidos = new ArrayList<>();
		List<PartidoDTO> partidosDTO = new ArrayList<>();
		partidos = service.listar();
		
		for (Partido p : partidos) {
			PartidoDTO d = new PartidoDTO();
			d.setIdPartido(p.getIdPartido());
			d.setEquipoLocal(p.getEquipoLocal());
			d.setEquipoVisitante(p.getEquipoVisitante());
			d.setEstadio(p.getEstadio());
			
			ControllerLinkBuilder linkTo = linkTo(methodOn(PartidoController.class).listarPorId((p.getIdPartido())));
			d.add(linkTo.withSelfRel());
			partidosDTO.add(d);
			
			ControllerLinkBuilder linkTo1 = linkTo(methodOn(PartidoController.class).listarPorId((p.getEquipoLocal().getIdEquipo())));
			d.add(linkTo1.withSelfRel());
			partidosDTO.add(d);
			
			ControllerLinkBuilder linkTo2 = linkTo(methodOn(PartidoController.class).listarPorId((p.getEquipoVisitante().getIdEquipo())));
			d.add(linkTo2.withSelfRel());
			partidosDTO.add(d);
			
			ControllerLinkBuilder linkTo3 = linkTo(methodOn(PartidoController.class).listarPorId((p.getEstadio().getIdEstadio())));
			d.add(linkTo3.withSelfRel());
			partidosDTO.add(d);	 
		}
		
		return partidosDTO;
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody PartidoResultadoDTO partidoDTO) {
		Partido obj = service.registrarTransaccional(partidoDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPartido()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Partido> modificar(@Valid @RequestBody Partido partido) {
		Partido obj = service.modificar(partido);
		return new ResponseEntity<Partido>(obj, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Partido obj = service.leerPorId(id);
		if(obj.getIdPartido() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id);
		}
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@PostMapping("/buscar")
	public ResponseEntity<List<Partido>> buscar(@RequestBody FiltroPartidoDTO filtro) {
		List<Partido> partidos = new ArrayList<>();

		if (filtro != null) {
			partidos = service.buscarFecha(filtro);		
		}
		return new ResponseEntity<List<Partido>>(partidos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarResumen")
	public ResponseEntity<List<PartidoResumenDTO>> listarResumen() {
		List<PartidoResumenDTO> consultas = new ArrayList<>();
		consultas = service.listarResumen();
		return new ResponseEntity<List<PartidoResumenDTO>>(consultas, HttpStatus.OK);
	}

}
