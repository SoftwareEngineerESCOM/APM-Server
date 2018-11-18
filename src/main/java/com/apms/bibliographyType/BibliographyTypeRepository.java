package com.apms.bibliographyType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliographyTypeRepository extends JpaRepository<BibliographyType, Integer> {
}
