package com.portfolio.backend.controller;

import com.portfolio.backend.model.Mensaje;
import com.portfolio.backend.model.Skill;
import com.portfolio.backend.service.ISkillService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
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
Controlador de la seccion 'Skills' donde se nombrara alguna habilidad y su porcentaje en una barra de progreso.
 */
@CrossOrigin(origins = "https://portfolio-sofia-egana.web.app")
@RestController
public class SkillController {

    @Autowired
    private ISkillService interSkill;

    @GetMapping("/api/skill/traer")
    public List<Skill> getSkills() {

        return interSkill.getSkills();
    }

    @GetMapping("/api/skill/{id}")
    public Skill getSkillId(@PathVariable Long id) {
        return interSkill.findSkill(id);
    }

    @PostMapping("/api/skill/crear")
    public ResponseEntity<Object> createSkill(@RequestBody Skill skl) {

                if (StringUtils.isBlank(skl.getUrlSkill())) {
            return new ResponseEntity(new Mensaje("Ingresar URL de imagen de la habilidad"), HttpStatus.BAD_REQUEST);
        }
                        if (StringUtils.isBlank(skl.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("Ingresar nombre de la habilidad"), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(skl.getDescripcionSkill())) {
            return new ResponseEntity(new Mensaje("Ingresar descripción de la habilidad"), HttpStatus.BAD_REQUEST);
        }
        interSkill.saveSkill(skl);
        return new ResponseEntity<>(new Result("La sección 'skill' ha sido creada correctamente"), HttpStatus.OK);
    }

    @DeleteMapping("/api/skill/borrar/{id}")
    public String deleteSkill(@PathVariable Long id) {

        interSkill.deleteSkill(id);
        return "La habilidad ha sido elimanada correctamente";
    }

    @PutMapping("/api/skill/editar/{id}")
    public ResponseEntity<?> editSkill(@PathVariable Long id,
            @RequestParam("url") String urlSkill,
            @RequestParam("nombre") String nombreSkill,
            @RequestParam("descripcion") String descripcionSkill) {

        Skill skl = interSkill.findSkill(id);

        skl.setUrlSkill(urlSkill);
        skl.setNombreSkill(nombreSkill);
        skl.setDescripcionSkill(descripcionSkill);

        if (StringUtils.isBlank(skl.getUrlSkill())) {
            return new ResponseEntity(new Mensaje("Ingresar una URL"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(skl.getNombreSkill())) {
            return new ResponseEntity(new Mensaje("Ingresar el nombre de la habilidad"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(skl.getDescripcionSkill())) {
            return new ResponseEntity(new Mensaje("Ingresar una breve descipción de la habilidad"), HttpStatus.BAD_REQUEST);
        }

        interSkill.saveSkill(skl);
        return new ResponseEntity(new Mensaje("La sección 'skill' ha sido actualizada correctamente"), HttpStatus.OK);
    }

}
