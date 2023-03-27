package com.portfolio.backend.controller;

import com.portfolio.backend.model.CursosCertificaciones;
import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.service.ICursosCertificacionesService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "https://portfolio-sofia-egana.web.app")
@RestController
public class CursosCertificacionesController {

    @Autowired
    private ICursosCertificacionesService interCursosCertificaciones;

    @GetMapping("/api/CursosCertificaciones/traer")
    public List<CursosCertificaciones> getCursosCertificaciones() {

        return interCursosCertificaciones.getCursosCertificaciones();
    }

    @GetMapping("/api/CursosCertificaciones/{id}")
    public CursosCertificaciones getCursosCertificacionesById(@PathVariable Long id) {
        return interCursosCertificaciones.findCursosCertificaciones(id);
    }

    @PostMapping("/api/CursosCertificaciones/crear")
    public ResponseEntity<Object> createCursosCertificaciones(@RequestBody CursosCertificaciones curso) {

        if (StringUtils.isBlank(curso.getUrlImg())) {

            return new ResponseEntity(new Mensaje("Ingresar una URL"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(curso.getTitulo())) {

            return new ResponseEntity(new Mensaje("Ingresar un título"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(curso.getFecha())) {

            return new ResponseEntity(new Mensaje("Ingresar una fecha de incio y de finalización de la actividad"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(curso.getUrlCertificado())) {

            return new ResponseEntity(new Mensaje("Ingresar una URL"), HttpStatus.BAD_REQUEST);
        }

        interCursosCertificaciones.saveCursosCertificaciones(curso);

        return new ResponseEntity<>(new Mensaje("La sección CursosCertificaciones ha sido creada"), HttpStatus.OK);
    }

    @DeleteMapping("/api/CursosCertificaciones/borrar/{id}")
    public String deleteCursosCertificaciones(@PathVariable Long id) {

        interCursosCertificaciones.deleteCursosCertificaciones(id);
        return "El curso/la certificación ha sido eliminada de forma exitosa";
    }

    @PutMapping("/api/CursosCertificaciones/editar/{id}")
    public ResponseEntity<?> editCursosCertificaciones(@PathVariable Long id,
            @RequestParam("urlImg") String urlImg,
            @RequestParam("titulo") String titulo,
            @RequestParam("fecha") String fecha,
            @RequestParam("urlCertificado") String urlCertificado) {

        CursosCertificaciones curso = interCursosCertificaciones.findCursosCertificaciones(id);
        curso.setUrlImg(urlImg);
        curso.setTitulo(titulo);
        curso.setFecha(fecha);
        curso.setUrlCertificado(urlCertificado);

        if (StringUtils.isBlank(curso.getUrlImg())) {

            return new ResponseEntity(new Mensaje("Ingresar una URL"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(curso.getTitulo())) {

            return new ResponseEntity(new Mensaje("Ingresar un título"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(curso.getFecha())) {

            return new ResponseEntity(new Mensaje("Ingresar una fecha de incio y de finalización de la actividad"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(curso.getUrlCertificado())) {

            return new ResponseEntity(new Mensaje("Ingresar una URL"), HttpStatus.BAD_REQUEST);
        }

        interCursosCertificaciones.saveCursosCertificaciones(curso);

        return new ResponseEntity(new Mensaje("Se han guardado los cambios"), HttpStatus.OK);

    }
}
