
package com.portfolio.backend.model;

import javax.persistence.Column;
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
public class Footer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String nombre;
    @NotBlank
    private String email;
    @NotBlank
    @Column (length = 1500)
    private String mensaje;

    public Footer() {
    }

    public Footer(Long id, String nombre, String email, String mensaje) {

        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.mensaje = mensaje;

    }
}
