package com.SpringSecurity.Etudiant_document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Etudiant_documentRepository extends JpaRepository<Etudiant_document,Integer>{

}
