package com.persona.demo_personas.controller.impl;

import com.persona.demo_personas.Exceptions.EmailExist;
import com.persona.demo_personas.Exceptions.LocalNotFoundException;
import com.persona.demo_personas.controller.PersonaController;
import com.persona.demo_personas.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.persona.demo_personas.service.PersonaService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/personas")
public class PersonaControllerImpl implements PersonaController {

    @Autowired
    private PersonaService personaService;

    @Override
    @PostMapping
    public Persona createPersona(@RequestBody Persona persona) throws EmailExist {
        return personaService.crearPersona(persona);
    }

    @Override
    @GetMapping("{id}")
    public Persona getPersonaById(@PathVariable("id") UUID id) throws LocalNotFoundException{
        return personaService.getPersona(id);
    }

    @GetMapping
    public List<Persona> getAllPersonas() throws LocalNotFoundException{
        return personaService.getAllPersonas();
    }
}
