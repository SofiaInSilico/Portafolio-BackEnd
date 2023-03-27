
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Herramientas;
import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.service.IHerramientasService;
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
public class HerramientasController {
    
    @Autowired
    private IHerramientasService interHerramientas;

    @GetMapping("/api/herramientas/traer")
    public List<Herramientas> getHerramientas() {

        return interHerramientas.getHerramientas();
    }
    
    @GetMapping("/api/herramientas/{id}")
    public Herramientas getHerramientasById(@PathVariable Long id) {
        return interHerramientas.findHerramientas(id);
    }

    @PostMapping("/api/herramientas/crear")
    public ResponseEntity<Object> createHerramientas(@RequestBody Herramientas tool) {

        if (StringUtils.isBlank(tool.getUrlImg())) {

            return new ResponseEntity(new Mensaje("Ingresar una URL"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(tool.getNombreHerramienta())) {

            return new ResponseEntity(new Mensaje("Ingresar el nombre de la herramienta"), HttpStatus.BAD_REQUEST);
        }


        interHerramientas.saveHerramientas(tool);

        return new ResponseEntity<>(new Mensaje("La sección Herramientas ha sido creada"), HttpStatus.OK);
    }

    @DeleteMapping("/api/herramientas/borrar/{id}")
    public String deleteHerramientas(@PathVariable Long id) {

        interHerramientas.deleteHerramientas(id);
        return "La Herramienta ha sido eliminada de forma exitosa";
    }
    @PutMapping("/api/herramientas/editar/{id}")
    public ResponseEntity<?> editHerramientas(@PathVariable Long id,
            @RequestParam("urlImg") String urlImg,
            @RequestParam("nombreHerramienta") String nombreHerramienta) {

        Herramientas tool = interHerramientas.findHerramientas(id);
        tool.setUrlImg(urlImg);
        tool.setNombreHerramienta(nombreHerramienta);

        if (StringUtils.isBlank(tool.getUrlImg())) {

            return new ResponseEntity(new Mensaje("Ingresar una URL"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(tool.getNombreHerramienta())) {

            return new ResponseEntity(new Mensaje("Ingresar el nombre de la herramienta"), HttpStatus.BAD_REQUEST);
        }

     

        interHerramientas.saveHerramientas(tool);

        return new ResponseEntity(new Mensaje("Se han guardado los cambios"), HttpStatus.OK);

    }
}
