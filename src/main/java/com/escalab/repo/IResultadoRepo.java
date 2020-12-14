package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.escalab.model.Resultado;

public interface IResultadoRepo  extends JpaRepository<Resultado, Integer>  {
	
	@Modifying
	@Query(value = "INSERT INTO resultado(id_partido, local, visitante) VALUES (:idPartido, :local, :visitante)", nativeQuery = true)
	Integer registrar(@Param("idPartido") Integer idPartido, @Param("local") Integer local, @Param("visitante") Integer visitante);

}
