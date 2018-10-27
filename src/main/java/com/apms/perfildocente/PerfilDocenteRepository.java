package com.apms.perfildocente;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilDocenteRepository extends CrudRepository<PerfilDocente, Integer>{
	
}
