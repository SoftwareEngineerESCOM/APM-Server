package com.apms.accreditationType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccreditationTypeRepository extends JpaRepository<AccreditationType, Integer> {
}
