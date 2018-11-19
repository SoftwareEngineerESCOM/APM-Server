package com.apms.thematicUnit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThematicUnitRepository extends JpaRepository<ThematicUnit, Integer> {
}
