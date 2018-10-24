package com.apms.tema;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.Query;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long>{

}
