package com.apms.subtema;


import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

//import org.springframework.data.jpa.repository.Query;

@Repository
public interface SubtemaRepository extends JpaRepository<Subtema, Long>{

}
