package com.apms.habilidad;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabilidadRepository extends CrudRepository<Habilidad, Integer>{
	
}
