package com.apms.bibliographyRelation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliographyRelationRepository extends JpaRepository<BibliographyRelation, Integer> {

}
