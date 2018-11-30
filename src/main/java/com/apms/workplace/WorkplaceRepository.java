package com.apms.workplace;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkplaceRepository extends JpaRepository<Workplace, Integer> {
	// Recibo idUsuario
	@Query(value = "SELECT * FROM workplace WHERE workplace_type_id = (SELECT id FROM workplace_type WHERE abbreviation = 'U.A.')", nativeQuery = true)
	List<Workplace> getAcademicUnits();
}
