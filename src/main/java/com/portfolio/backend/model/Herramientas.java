package com.portfolio.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Herramientas {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String urlImg;
    @NotBlank
    private String nombreHerramienta;
    public Herramientas() {
    }

    public Herramientas(Long id, String urlImg, String nombreHerramienta) {

        this.id = id;
        this.urlImg = urlImg;
        this.nombreHerramienta = nombreHerramienta;

    }
}
