package com.SpringSecurity.sousdiscipline;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SousDisciplineRepository extends JpaRepository<SousDiscipline,Integer>{

}
