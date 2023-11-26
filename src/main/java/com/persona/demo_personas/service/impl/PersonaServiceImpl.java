package com.persona.demo_personas.service.impl;

import com.persona.demo_personas.Exceptions.EmailExist;
import com.persona.demo_personas.Exceptions.LocalNotFoundException;
import com.persona.demo_personas.Utils.Utils;
import com.persona.demo_personas.controller.impl.AuthenticationRequest;
import com.persona.demo_personas.controller.impl.AuthenticationResponse;
import com.persona.demo_personas.controller.impl.RegisterRequest;
import com.persona.demo_personas.model.Persona;
import com.persona.demo_personas.model.Telefono;
import com.persona.demo_personas.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import com.persona.demo_personas.service.PersonaService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {
    @Autowired
    private PersonaRepository personaRepository;


    @Override
    public AuthenticationResponse register( RegisterRequest request ) {
        var user = User.builder()
                .username(request.getUserName())

                .build();
        return null;
    }

    @Override
    public AuthenticationResponse authenticate( AuthenticationRequest request ) {
        return null;
    }

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
        if (persona.getPhones() != null) {
            for (Telefono telefono : persona.getPhones()) {
                telefono.setPersona(persona);
            }
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
