package com.persona.demo_personas.service;

import com.persona.demo_personas.Exceptions.LocalNotFoundException;
import com.persona.demo_personas.model.Persona;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PersonaService {
    public boolean verificarSiEmailExiste(String email);
    public Persona crearPersona(Persona persona) throws LocalNotFoundException;
    public Persona getPersona(Long id) throws LocalNotFoundException;
    public List<Persona> getAllPersonas() throws LocalNotFoundException;
}
