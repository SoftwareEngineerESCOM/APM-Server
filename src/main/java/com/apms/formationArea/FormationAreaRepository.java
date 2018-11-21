package com.apms.formationArea;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationAreaRepository extends JpaRepository<FormationArea, Integer> {

}
