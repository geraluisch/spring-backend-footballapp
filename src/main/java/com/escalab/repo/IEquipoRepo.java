package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Equipo;

public interface IEquipoRepo extends JpaRepository<Equipo, Integer>  {

}
