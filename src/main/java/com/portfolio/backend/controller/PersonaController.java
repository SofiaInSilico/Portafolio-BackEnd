package com.portfolio.backend.controller;

import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.model.Persona;
import com.portfolio.backend.service.IPersonaService;
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

/*
Controlador de la seccion "Persona" donde estara nombre, apellido, informacion de contacto, url a imagenes
del banner y de perfil.
 */
@CrossOrigin(origins = "https://portfolio-sofia-egana.web.app")
@RestController
public class PersonaController {

    @Autowired
    private IPersonaService interPersona;

    @GetMapping("/api/persona/traer")
    public List<Persona> getPersona() {

        return interPersona.getPersona();
    }

    @PostMapping("/api/persona/crear")
    public ResponseEntity<Object> createPersona(@RequestBody Persona perso) {

        if (StringUtils.isBlank(perso.getNombre())) {

            return new ResponseEntity(new Mensaje("Ingresar un nombre"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(perso.getTitulo())) {

            return new ResponseEntity(new Mensaje("Ingresar un título"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(perso.getUrlPerfil())) {

            return new ResponseEntity(new Mensaje("Ingresar una URL"), HttpStatus.BAD_REQUEST);
        }

        interPersona.savePersona(perso);

        return new ResponseEntity<>(new Mensaje("La sección Persona ha sido creada"), HttpStatus.OK);
    }

    @GetMapping("/api/persona/{id}")
    public Persona getPersonaById(@PathVariable Long id) {
        return interPersona.findPersona(id);
    }

    @DeleteMapping("/api/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {

        interPersona.deletePersona(id);
        return "La persona ha sido eliminada de forma exitosa";
    }

    @PutMapping("/api/persona/editar/{id}")
    public ResponseEntity<?> editPersona(@PathVariable Long id,
            @RequestParam("nombre") String nombre,
            @RequestParam("titulo") String titulo,
            @RequestParam("urlPerfil") String urlPerfil) {

        Persona perso = interPersona.findPersona(id);
        perso.setNombre(nombre);
        perso.setTitulo(titulo);
        perso.setUrlPerfil(urlPerfil);

        if (StringUtils.isBlank(perso.getNombre())) {

            return new ResponseEntity(new Mensaje("Ingresar un nombre"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(perso.getTitulo())) {

            return new ResponseEntity(new Mensaje("Ingresar un título"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(perso.getUrlPerfil())) {

            return new ResponseEntity(new Mensaje("Ingresar una URL"), HttpStatus.BAD_REQUEST);
        }

        interPersona.savePersona(perso);

        return new ResponseEntity(new Mensaje("Se han guardado los cambios"), HttpStatus.OK);

    }
}
