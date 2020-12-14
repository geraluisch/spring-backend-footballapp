package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Estadistica;

public interface IEstadisticaRepo extends JpaRepository<Estadistica, Integer>  {

}
