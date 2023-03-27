package com.portfolio.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String urlImagen;
    @NotBlank
    private String nombreProyecto;
    private String fechaProyecto;
    @NotBlank
    @Column(length = 1500)
    private String descripcionProyecto;
    @NotBlank
    private String urlProyecto;
    @NotBlank
    
    

    public Proyecto() {
    }

    public Proyecto(Long id, String nombreProyecto, String descripcionProyecto, String urlProyecto, String fechaProyecto, String urlImagen) {
        this.id = id;
        this.nombreProyecto = nombreProyecto;
        this.descripcionProyecto = descripcionProyecto;
        this.urlProyecto = urlProyecto;
        this.fechaProyecto = fechaProyecto;
        this.urlImagen = urlImagen;
    }

}
