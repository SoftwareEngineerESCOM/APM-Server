package com.apms.accreditationType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;

@Repository
public interface AccreditationTypeRepository extends JpaRepository<AccreditationType, Integer> {
	@Nullable
	@Query(value = "SELECT at FROM AccreditationType at WHERE at.name = :name")
	AccreditationType getAccreditationTypeByName(@Param("name") String name);
}
