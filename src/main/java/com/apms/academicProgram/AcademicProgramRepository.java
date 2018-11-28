package com.apms.academicProgram;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface AcademicProgramRepository extends JpaRepository<AcademicProgram, Integer> {
	@Query(value = "SELECT * FROM academic_program WHERE workplace_id = :id", nativeQuery = true)
	List<AcademicProgram> getAcademicProgramsByWorkPlaceId(@Param("id") Integer id);

	@Query(value = "SELECT * FROM academic_program WHERE name ILIKE :name AND workplace_id = :workplaceId", nativeQuery = true)
	List<AcademicProgram> getAcademicProgramByNameAndWorkplaceId(@Param("name") String name, @Param("workplaceId") Integer id);
	
}
