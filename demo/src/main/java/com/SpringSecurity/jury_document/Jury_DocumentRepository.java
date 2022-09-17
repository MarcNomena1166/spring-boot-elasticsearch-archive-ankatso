package com.SpringSecurity.jury_document;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Jury_DocumentRepository extends JpaRepository<Jury_document, Integer>{

	
	@Query(value = "delete FROM jury_document WHERE id_d = :idDoc", nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteJuryDocByIdDoc(@Param("idDoc") int idDoc);
}
