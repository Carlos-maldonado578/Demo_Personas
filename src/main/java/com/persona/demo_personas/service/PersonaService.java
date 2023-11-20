package com.persona.demo_personas.service;

import com.persona.demo_personas.Exceptions.EmailExist;
import com.persona.demo_personas.Exceptions.LocalNotFoundException;
import com.persona.demo_personas.model.Persona;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface PersonaService {
    public boolean verificarSiEmailExiste(String email);
    public Persona crearPersona(Persona persona) throws EmailExist;
    public Persona getPersona(UUID id) throws LocalNotFoundException;
    public List<Persona> getAllPersonas() throws LocalNotFoundException;
}
