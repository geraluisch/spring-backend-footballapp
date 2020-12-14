package com.escalab.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.escalab.model.Jugador;

public interface IJugadorRepo extends JpaRepository<Jugador, Integer> {

}
