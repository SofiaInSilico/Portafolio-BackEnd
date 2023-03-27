
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Footer;
import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.service.IFooterService;
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
Controlador de la sección "Footer", donde se ubicará un breve formulario de contacto, al igual que información de redes sociales
*/

@CrossOrigin(origins = "https://portfolio-sofia-egana.web.app")
@RestController
public class FooterController {
    
    
    @Autowired
    private IFooterService interEnd;
    
    
    @GetMapping("/api/footer/traer")
    public List<Footer> getFooter() {
        
        return interEnd.getFooter();
    }
    
    @GetMapping("/api/footer/{id}")
    public Footer getAcercaById(@PathVariable Long id) {
       return interEnd.findFooter(id);
    }
    
    @PostMapping("/api/footer/crear")
    public ResponseEntity<Object> createFooter(@RequestBody Footer end) {
        if(StringUtils.isBlank(end.getNombre())){
            return new ResponseEntity(new Mensaje("Ingresa tu nombre"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(end.getEmail())){
            return new ResponseEntity(new Mensaje("Ingresa tu e-mail"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(end.getMensaje())){
            return new ResponseEntity(new Mensaje("Ingresa un mensaje"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.length(end.getMensaje())>2000){
            return new ResponseEntity(new Mensaje("El mensaje no puede superar los 2000 caracteres"), HttpStatus.BAD_REQUEST);
        }
        
        interEnd.saveFooter(end);
        return new ResponseEntity<>(new Result("La sección 'Footer' se creó correctamente"), HttpStatus.OK);
    }   
    
    @DeleteMapping("/api/footer/borrar/{id}")
    public String deleteFooter (@PathVariable Long id) {
        
        interEnd.deleteFooter(id);
        return "La sección 'Footer' se eliminó correctamente";
    }
    
    @PutMapping("/api/footer/editar/{id}")
    public ResponseEntity<?> editFooter (@PathVariable Long id,
                                               @RequestParam ("nombre del contactánte") String nombre,
                                               @RequestParam ("e-mail del contactánte") String email,
                                               @RequestParam ("mensaje del contactánte") String mensaje) {
        
        Footer end = interEnd.findFooter(id);
        
        end.setNombre(nombre);
        end.setEmail(email);
        end.setMensaje(mensaje);
        
         if(StringUtils.isBlank(end.getNombre())){
            return new ResponseEntity(new Mensaje("Ingresa tu nombre"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(end.getEmail())){
            return new ResponseEntity(new Mensaje("Ingresa tu e-mail"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(end.getMensaje())){
            return new ResponseEntity(new Mensaje("Ingresa un mensaje"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.length(end.getMensaje())>2000){
            return new ResponseEntity(new Mensaje("El mensaje no puede superar los 2000 caracteres"), HttpStatus.BAD_REQUEST);
        }
        
        interEnd.saveFooter(end);
        return new ResponseEntity(new Mensaje("la sección 'footer' ha sido actualizada correctamente"),HttpStatus.OK);
    }
}
