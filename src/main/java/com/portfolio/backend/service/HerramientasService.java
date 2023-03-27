
package com.portfolio.backend.service;

import com.portfolio.backend.model.Herramientas;
import com.portfolio.backend.repository.HerramientasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HerramientasService implements IHerramientasService{
    
    @Autowired
    private HerramientasRepository toolRepository;
    
    @Override
    public void saveHerramientas(Herramientas tool){
        toolRepository.save(tool);
    }

    @Override
    public void deleteHerramientas(Long id) {
        toolRepository.deleteById(id);
    }

    @Override
    public Herramientas findHerramientas(Long id) {
        Herramientas tool = toolRepository.findById(id).orElse(null);
        return tool;
    }

    @Override
    public List<Herramientas> getHerramientas() {
        List<Herramientas> listaHerramientas = toolRepository.findAll();
        return listaHerramientas;
    }
}
