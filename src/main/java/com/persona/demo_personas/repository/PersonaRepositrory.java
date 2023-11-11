package com.persona.demo_personas.repository;

import com.persona.demo_personas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepositrory extends JpaRepository<Persona, Long> {
}
