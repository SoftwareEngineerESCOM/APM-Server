package com.apms.bibliografia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliografiaRepository extends JpaRepository<Bibliografia, Long>{

}
