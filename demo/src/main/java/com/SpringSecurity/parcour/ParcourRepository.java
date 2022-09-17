package com.SpringSecurity.parcour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcourRepository extends JpaRepository<Parcour,Integer>{

}
