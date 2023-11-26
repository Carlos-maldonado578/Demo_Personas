package com.persona.demo_personas.repository;

import com.persona.demo_personas.model.Persona;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, UUID> {
    boolean existsByEmail(String email);
    Optional<Persona> findByEmail(String email);
}
