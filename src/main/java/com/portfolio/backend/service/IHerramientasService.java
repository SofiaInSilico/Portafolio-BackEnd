package com.portfolio.backend.service;

import com.portfolio.backend.model.Herramientas;
import java.util.List;

public interface IHerramientasService {

    public List<Herramientas> getHerramientas();

    public void saveHerramientas(Herramientas tool);

    public void deleteHerramientas(Long id);

    public Herramientas findHerramientas(Long id);

}
