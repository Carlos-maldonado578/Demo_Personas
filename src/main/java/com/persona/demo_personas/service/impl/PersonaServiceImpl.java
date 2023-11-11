package com.persona.demo_personas.service.impl;

import com.persona.demo_personas.model.Persona;
import com.persona.demo_personas.repository.PersonaRepositrory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.persona.demo_personas.service.PersonaService;

import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepositrory personaRepositrory;

    @Override
    public Persona crearPersona(Persona persona) {
        return personaRepositrory.save(persona);
    }

    @Override
    public Persona getPersona(Long id) {
        Optional<Persona> optionalPersona = personaRepositrory.findById(id);
        return optionalPersona.get();
    }
}
