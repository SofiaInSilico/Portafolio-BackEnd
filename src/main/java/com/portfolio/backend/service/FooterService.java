package com.portfolio.backend.service;

import com.portfolio.backend.model.Footer;
import com.portfolio.backend.repository.FooterRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FooterService implements IFooterService {

    @Autowired
    private FooterRepository endRepository;

    @Override
    public List<Footer> getFooter() {

        List<Footer> listaFooter = endRepository.findAll();
        return listaFooter;
    }

    @Override
    public void saveFooter(Footer end) {

        endRepository.save(end);
    }

    @Override
    public void deleteFooter(Long id) {

        endRepository.deleteById(id);
    }

    @Override
    public Footer findFooter(Long id) {

        Footer end = endRepository.findById(id).orElse(null);
        return end;
    }

}
