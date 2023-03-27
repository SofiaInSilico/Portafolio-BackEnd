
package com.portfolio.backend.controller;

import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.model.Proyecto;
import com.portfolio.backend.service.IProyectoService;
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
Controlador de la seccion "Proyectos" donde se detallara los proyectos realizados con un enlace al github
y a su pagina (si es que existe).
*/

@CrossOrigin(origins = "https://portfolio-sofia-egana.web.app")
@RestController
public class ProyectoController {
    
    @Autowired
    private IProyectoService interProyecto;
    
    
    @GetMapping("/api/proyecto/traer")
    public List<Proyecto> getProyecto() {
    return interProyecto.getProyecto();
    }
    
    @GetMapping("/api/proyecto/{id}")
    public Proyecto getProyectoById(@PathVariable Long id) {
       return interProyecto.findProyecto(id);
    }
    
    @PostMapping("/api/proyecto/crear")
    public ResponseEntity<Object> createProyecto(@RequestBody Proyecto pro){
        if(StringUtils.isBlank(pro.getDescripcionProyecto())){
            return new ResponseEntity(new Mensaje("Ingresar la descripción del proyecto"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(pro.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("Ingresar el nombre del proyecto"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(pro.getFechaProyecto())){
            return new ResponseEntity(new Mensaje("Ingresar la fecha de inicio y de finalización del proyecto"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(pro.getUrlProyecto())){
            return new ResponseEntity(new Mensaje("Ingresar la URL del proyecto"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.length(pro.getDescripcionProyecto())>1500){
            return new ResponseEntity(new Mensaje("La descripción no puede superar los 1500 caracteres"), HttpStatus.BAD_REQUEST);
        }
        interProyecto.saveProyecto(pro);
        return new ResponseEntity<>(new Result("La sección 'proyecto' ha sido creada correctamente"),HttpStatus.OK);
    }
    
    @DeleteMapping("/api/proyecto/borrar/{id}")
    public String deleteProyecto (@PathVariable Long id){
        
        interProyecto.deleteProyecto(id);
        return "La seccioó 'proyecto' ha sido eliminada correctamente";
    }
    
    @PutMapping("/api/proyecto/editar/{id}")
    public ResponseEntity<?> editProyecto (@PathVariable Long id,
                                  @RequestParam("nombre del proyecto") String nombreProyecto,
                                  @RequestParam("Descripcion del proyecto") String descripcionProyecto,
                                  @RequestParam("URL del proyecto") String urlProyecto,
                                  @RequestParam("fecha del Proyecto")String fechaProyecto,
                                  @RequestParam("url de la imagen")String urlImagen){
        
        Proyecto pro = interProyecto.findProyecto(id);
        
        pro.setDescripcionProyecto(descripcionProyecto);
        pro.setNombreProyecto(nombreProyecto);
        pro.setUrlProyecto(urlProyecto);
        pro.setFechaProyecto(fechaProyecto);
        pro.setUrlImagen(urlImagen);
        
        if(StringUtils.isBlank(pro.getDescripcionProyecto())){
            return new ResponseEntity(new Mensaje("Ingresar la descripción del proyecto"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(pro.getNombreProyecto())){
            return new ResponseEntity(new Mensaje("Ingresar el nombre del proyecto"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(pro.getFechaProyecto())){
            return new ResponseEntity(new Mensaje("Ingresar la fecha de inicio y de finalización del proyecto"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(pro.getUrlProyecto())){
            return new ResponseEntity(new Mensaje("La url al proyecto es obligatoria"), HttpStatus.BAD_REQUEST);
        }
         if (StringUtils.length(pro.getDescripcionProyecto())>1500){
            return new ResponseEntity(new Mensaje("La descripcion no puede superar los 1500 caracteres"), HttpStatus.BAD_REQUEST);
        }
        
        interProyecto.saveProyecto(pro);
        return new ResponseEntity(new Mensaje("La sección 'Proyecto' ha sido actualizada correctamente"), HttpStatus.OK);
    }
    
}
