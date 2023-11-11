package com.persona.demo_personas.service;

import com.persona.demo_personas.model.Persona;
import org.springframework.stereotype.Component;

@Component
public interface PersonaService {
    public Persona crearPersona(Persona persona);
    public Persona getPersona(Long id);
}
