package com.cortez.proyectos.api_crud.services;

import java.util.List;

import com.cortez.proyectos.api_crud.models.Persona;

public interface PersonaService {

    //crear(C),leer(R),actualizar(U),eliminar(D)

    //metodo crear
    public Persona crearPersona(Persona personaNueva);

    //metodo leer
    public List<Persona> traerPersonas();

    //metodo traer por id
    public Persona traerPersonaPorId(Long id);

    //metodo actualizar
    public Persona actualizarPersona(Long id,Persona personaActualizar);

    //metodo eliminar
    public void eliminarPersona(Long id);
}
