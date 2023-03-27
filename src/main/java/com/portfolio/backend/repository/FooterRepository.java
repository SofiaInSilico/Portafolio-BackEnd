
package com.portfolio.backend.repository;

import com.portfolio.backend.model.Footer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooterRepository extends JpaRepository <Footer, Long>{
    
}
