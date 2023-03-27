package com.portfolio.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String titulo;
    @NotBlank
    private String urlPerfil;

    public Persona() {
    }

    public Persona(Long id, String nombre, String titulo, String urlPerfil) {
        this.id = id;
        this.nombre = nombre;
        this.titulo = titulo;
        this.urlPerfil = urlPerfil;
    }

}
