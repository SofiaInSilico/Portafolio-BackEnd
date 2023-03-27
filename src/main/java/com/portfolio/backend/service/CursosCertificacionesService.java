
package com.portfolio.backend.service;

import com.portfolio.backend.model.CursosCertificaciones;
import com.portfolio.backend.repository.CursosCertificacionesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CursosCertificacionesService implements ICursosCertificacionesService{
    
    @Autowired
    private CursosCertificacionesRepository cursoRepository;
    
    @Override
    public void saveCursosCertificaciones(CursosCertificaciones curso){
        cursoRepository.save(curso);
    }

    @Override
    public void deleteCursosCertificaciones(Long id) {
        cursoRepository.deleteById(id);
    }

    @Override
    public CursosCertificaciones findCursosCertificaciones(Long id) {
        CursosCertificaciones curso = cursoRepository.findById(id).orElse(null);
        return curso;
    }

    @Override
    public List<CursosCertificaciones> getCursosCertificaciones() {
        List<CursosCertificaciones> listaCursosCertificaciones = cursoRepository.findAll();
        return listaCursosCertificaciones;
    }

}
    
