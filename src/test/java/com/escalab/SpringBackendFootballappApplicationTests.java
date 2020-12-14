package com.escalab;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.escalab.model.Equipo;
import com.escalab.model.Estadio;
import com.escalab.model.Posicion;
import com.escalab.model.Usuario;
import com.escalab.repo.IEquipoRepo;
import com.escalab.repo.IEstadioRepo;
import com.escalab.repo.IPosicionRepo;
import com.escalab.repo.IUsuarioRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBackendFootballappApplicationTests {
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private IPosicionRepo repoPosicion;
	
	@Autowired
	private IEstadioRepo repoEstadio;
	
	@Autowired
	private IEquipoRepo repoEquipo;	
	
	@Autowired
	private IUsuarioRepo repoUsuario;
	
	private Date dateToConvert = new Date();

	@Test
	public void crearPosicion() {
		Posicion posicion = new Posicion();
		posicion.setDescripcion("Delantero");
		
		Posicion retorno = repoPosicion.save(posicion);
		
		assertTrue(retorno.getDescripcion().equalsIgnoreCase(posicion.getDescripcion()));
	}
	
	@Test
	public void crearEstadio() {		
		Estadio estadio = new Estadio();
		estadio.setNombre("Estadio Olimpico");
		estadio.setFecha(new java.sql.Timestamp(
			      	     dateToConvert.getTime()).toLocalDateTime());
		 
		Estadio retorno = repoEstadio.save(estadio);
		
		assertTrue(retorno.getNombre().equalsIgnoreCase(estadio.getNombre()));
	}
	
	@Test
	public void crearEquipo() {
		Equipo equipo = new Equipo();
		Estadio estadio = new Estadio();		
		estadio.setIdEstadio(1);
		equipo.setFechaFundacion(new java.sql.Timestamp(
		      				 dateToConvert.getTime()).toLocalDateTime());
		equipo.setIdEstadio(estadio);
		equipo.setNombre("Zulia FC");
		
		Equipo retorno = repoEquipo.save(equipo);
		
		assertTrue(retorno.getNombre().equalsIgnoreCase(equipo.getNombre()));
	}
		
	
	@Test
	public void crearUsuario() {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);
		usuario.setUsername("geraluisch@gmail.com");
		usuario.setPassword(bcrypt.encode("123"));
		usuario.setEnabled(true);
		
		Usuario retorno = repoUsuario.save(usuario);
		
		assertTrue(retorno.getPassword().equalsIgnoreCase(usuario.getPassword()));
	}
	

}
