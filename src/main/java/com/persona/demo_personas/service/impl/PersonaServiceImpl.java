package com.persona.demo_personas.service.impl;

import com.persona.demo_personas.Exceptions.EmailExist;
import com.persona.demo_personas.Exceptions.LocalNotFoundException;
import com.persona.demo_personas.Utils.Utils;
import com.persona.demo_personas.model.Persona;
import com.persona.demo_personas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.persona.demo_personas.service.PersonaService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public boolean verificarSiEmailExiste(String email) {
        return personaRepository.existsByEmail(email);
    }

    @Override
    public Persona crearPersona(Persona persona) throws EmailExist {
        if (!Utils.validaPassword(persona.getPassword())) {
            throw new EmailExist("Formato de password incorrecto");
        }
        if (!Utils.esCorreoValido(persona.getEmail())) {
            throw new EmailExist("Formato de correo electrónico incorrecto");
        }
        if (verificarSiEmailExiste(persona.getEmail())){
            throw new EmailExist("Mail ya existe");
        }
        return personaRepository.save(persona);
    }

    @Override
    public Persona getPersona(UUID id) throws LocalNotFoundException{
        Optional<Persona> optionalPersona = personaRepository.findById(id);
        if (optionalPersona.isEmpty()){
            throw new LocalNotFoundException("No encontrado");
        }
        return optionalPersona.get();
    }

    @Override
    public List<Persona> getAllPersonas() throws LocalNotFoundException{
        return personaRepository.findAll();
    }
}
