package com.apms.bibliography;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliographyRepository extends JpaRepository<Bibliography, Integer> {
}
