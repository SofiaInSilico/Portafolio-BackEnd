
package com.portfolio.backend.repository;

import com.portfolio.backend.model.CursosCertificaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CursosCertificacionesRepository extends JpaRepository <CursosCertificaciones, Long> {
    
}

    

