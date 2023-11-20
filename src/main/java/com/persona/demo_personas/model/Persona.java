package com.persona.demo_personas.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    private String email;
    private String password;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "persona")
    private List<Telefono> phones;
    private LocalDateTime created;
    private LocalDateTime modified;
    private LocalDateTime lastLogin;
    private boolean isActive;
    @PrePersist
    protected void onCreate() {
        created = LocalDateTime.now();
        lastLogin = created;
    }
    @PreUpdate
    protected void onUpdate() {
        modified = LocalDateTime.now();
    }
}
