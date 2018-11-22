package com.apms.binnacle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinnacleRepository extends JpaRepository<Binnacle, Integer> {

}
