package com.apms.perfil;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Integer>{
	
}
