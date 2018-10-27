package com.apms.actitud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActitudRepository extends JpaRepository<Actitud, Long> {

}
