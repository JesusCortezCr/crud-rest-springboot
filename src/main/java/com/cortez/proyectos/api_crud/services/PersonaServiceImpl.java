package com.cortez.proyectos.api_crud.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cortez.proyectos.api_crud.models.Persona;
import com.cortez.proyectos.api_crud.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService{

    private final PersonaRepository personaRepository;
    

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public Persona crearPersona(Persona personaNueva) {
        Persona nuevaPersona=personaRepository.save(personaNueva);
        return nuevaPersona;
    }

    @Override
    public List<Persona> traerPersonas() {
        List<Persona> listaPersonas=personaRepository.findAll();
        return listaPersonas;
    }

    @Override
    public Persona traerPersonaPorId(Long id){
        Persona personaEncontrada= personaRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro a la persona con el id"+id));
        return personaEncontrada;
    }

    @Override
    public Persona actualizarPersona(Long id, Persona personaActualizar) {
        //consigo los datos nuevos 
        //busco el codigo de la persona(id)
        //asignar nuevos valores
        Persona personaAntigua= personaRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro a la persona con el id"+id));
        //asignacion de nuevos valores
        personaAntigua.setNombre(personaActualizar.getNombre());
        personaAntigua.setApellido(personaActualizar.getApellido());
        personaAntigua.setCorreo(personaActualizar.getCorreo());
        //actualizar
        personaRepository.save(personaAntigua);
        return personaAntigua;
    }

    @Override
    public void eliminarPersona(Long id) {
        if(id!=null){
            personaRepository.deleteById(id);
        }
    }

}
