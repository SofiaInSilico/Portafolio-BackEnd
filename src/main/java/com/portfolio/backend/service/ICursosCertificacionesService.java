
package com.portfolio.backend.service;

import com.portfolio.backend.model.CursosCertificaciones;
import java.util.List;


public interface ICursosCertificacionesService {
    
    public List<CursosCertificaciones> getCursosCertificaciones ();
    
    public void saveCursosCertificaciones (CursosCertificaciones curso);
    
    public void deleteCursosCertificaciones (Long id);
    
    public CursosCertificaciones findCursosCertificaciones (Long id);
}
