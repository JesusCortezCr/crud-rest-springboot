package com.cortez.proyectos.api_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cortez.proyectos.api_crud.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona,Long>{

}
