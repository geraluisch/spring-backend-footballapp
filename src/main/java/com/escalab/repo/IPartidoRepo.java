package com.escalab.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.escalab.model.Partido;

public interface IPartidoRepo extends JpaRepository<Partido, Integer>  {
	
	@Query("from Partido p where p.fecha between :fechaPartido and :fechaSgte")
	List<Partido> buscarFecha(@Param("fechaPartido") LocalDateTime fechaP, @Param("fechaSgte") LocalDateTime fechaSgte);
	
	@Query(value = "select * from fn_listarResumen()", nativeQuery = true)
	List<Object[]> listarResumen();

}
