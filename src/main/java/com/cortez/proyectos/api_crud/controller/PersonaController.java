package com.cortez.proyectos.api_crud.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cortez.proyectos.api_crud.models.Persona;
import com.cortez.proyectos.api_crud.services.PersonaService;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }
    
    //leer get
    @GetMapping
    public ResponseEntity<List<Persona>> traerPersonas(){
        List<Persona> personasLista=personaService.traerPersonas();
        if(personasLista.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(personasLista,HttpStatus.OK);
    }

    //traer por id get
    @GetMapping("/{id}")
    public ResponseEntity<Persona> buscarPorId(@PathVariable Long id){
        try {
            Persona personaEncontrada=personaService.traerPersonaPorId(id);
            return new ResponseEntity<>(personaEncontrada,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //crear persona
    @PostMapping
    public ResponseEntity<Persona> crearPersona(@RequestBody Persona personaDatos){
        Persona personaNueva=personaService.crearPersona(personaDatos);
        return new ResponseEntity<>(personaNueva,HttpStatus.CREATED);
    }

    //actualizar persona
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Persona> actualizarPersona(@PathVariable Long id,@RequestBody Persona personaDatosNuevos){
        try {
            Persona personaActualizada=personaService.actualizarPersona(id, personaDatosNuevos);
            return new ResponseEntity<>(personaActualizada,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //eliminar persona
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        try {
            personaService.eliminarPersona(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
