package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Estadio;

public interface IEstadioRepo extends JpaRepository<Estadio, Integer>  {

}
