package com.SpringSecurity.domaine_mention;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Domaine_MentionRepository extends JpaRepository<Domaine_mention,Integer>{

}
