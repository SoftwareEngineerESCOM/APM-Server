package com.apms.bibliographyRelation;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliographyRelationRepository extends JpaRepository<BibliographyRelation, Integer> {
	@Query(value = "SELECT * FROM bibliography_relation WHERE learning_unit_id = :id", nativeQuery = true)
	List<BibliographyRelation> getBibliographyRelationByLearningUnitId(@Param("id") Integer id);
}
