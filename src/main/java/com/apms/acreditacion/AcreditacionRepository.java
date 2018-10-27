package com.apms.acreditacion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcreditacionRepository extends JpaRepository<Acreditacion, Long>{

}
