
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
public class CursosCertificaciones {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String urlImg;
    @NotBlank
    private String titulo;
    @NotBlank
    private String institucion;
    @NotBlank
    private String fecha;
    @NotBlank
    private String urlCertificado;

    public CursosCertificaciones() {
    }

    public CursosCertificaciones(Long id, String urlImg, String titulo, String institucion, String fecha, String urlCertificado, String sobreMi) {
        this.id = id;
        this.urlImg = urlImg;
        this.titulo = titulo;
        this.institucion = institucion;
        this.fecha = fecha;
        this.urlCertificado = urlCertificado;
    }

}
