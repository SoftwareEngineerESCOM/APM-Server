package com.apms.ensenansa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnsenansaRepository extends JpaRepository<Ensenansa, Long>{

}
