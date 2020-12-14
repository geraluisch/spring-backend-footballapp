package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Posicion;

public interface IPosicionRepo extends JpaRepository<Posicion, Integer>  {

}
