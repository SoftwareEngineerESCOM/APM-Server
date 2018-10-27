package com.apms.practica;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticaRepository extends CrudRepository<Practica, Integer>{

}
