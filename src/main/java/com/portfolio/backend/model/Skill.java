package com.portfolio.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank
    private String urlSkill;
    @NotBlank
    private String nombreSkill;
    @NotBlank
    private String descripcionSkill;

    public Skill() {
    }

    public Skill(Long id, String urlSkill, String nombreSkill, String descripcionSkill) {
        this.id = id;
        this.urlSkill = urlSkill;
        this.nombreSkill = nombreSkill;
        this.descripcionSkill = descripcionSkill;
    }

}
