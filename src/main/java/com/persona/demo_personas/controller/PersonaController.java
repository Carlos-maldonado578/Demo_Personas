package com.persona.demo_personas.controller;

import com.persona.demo_personas.Exceptions.EmailExist;
import com.persona.demo_personas.Exceptions.LocalNotFoundException;
import com.persona.demo_personas.model.Persona;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface PersonaController {
    public Persona createPersona(@RequestBody Persona persona) throws EmailExist;
    public Persona getPersonaById(@PathVariable("id") UUID id) throws LocalNotFoundException;
    public List<Persona> getAllPersonas() throws LocalNotFoundException;
}
