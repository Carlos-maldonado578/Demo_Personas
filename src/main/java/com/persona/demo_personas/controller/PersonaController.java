package com.persona.demo_personas.controller;

import com.persona.demo_personas.model.Persona;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PersonaController {
    public Persona createPersona(Persona persona);
    public Persona getPersonasById(Long id);
}
