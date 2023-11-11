package com.persona.demo_personas.controller.impl;

import com.persona.demo_personas.controller.PersonaController;
import com.persona.demo_personas.model.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("api/personas")
public class PersonaControllerImpl implements PersonaController {

    private PersonaService personaService;

    @Override
    @PostMapping
    public Persona createPersona(Persona persona) {
        return personaService.crearPersona(persona);
    }

    @Override
    @GetMapping("{id}")
    public Persona getPersonasById(@PathVariable("id") Long id) {
        return personaService.getPersona(id);
    }
}
