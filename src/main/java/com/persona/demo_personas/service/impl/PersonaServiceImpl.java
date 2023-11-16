package com.persona.demo_personas.service.impl;

import com.persona.demo_personas.Exceptions.LocalNotFoundException;
import com.persona.demo_personas.model.Persona;
import com.persona.demo_personas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.persona.demo_personas.service.PersonaService;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public boolean verificarSiEmailExiste(String email) {
        return personaRepository.existsByEmail(email);
    }

    @Override
    public Persona crearPersona(Persona persona) throws LocalNotFoundException {
        Optional<Persona> result = Optional.of(personaRepository.save(persona));
        if (verificarSiEmailExiste(persona.getEmail())){
            throw new LocalNotFoundException("Mail ya existe");
        }
        return result.get();
    }

    @Override
    public Persona getPersona(Long id) throws LocalNotFoundException{
        Optional<Persona> optionalPersona = personaRepository.findById(id);
        return optionalPersona.get();
    }

    @Override
    public List<Persona> getAllPersonas() throws LocalNotFoundException{
        return personaRepository.findAll();
    }
}
