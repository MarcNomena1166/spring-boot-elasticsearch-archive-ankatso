package com.SpringSecurity.document_a_valider;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpringSecurity.institution.Institution;

@Repository
public interface Document_a_validerRepository extends JpaRepository<Document_a_valider, Integer>{

	@Query(value = "update document_a_valider set statuts='valide' where id = :id", nativeQuery = true)
	@Modifying
	@Transactional
	public void updateDocumentAValider(@Param("id")int id);
	
	@Query(value = "update document_a_valider set commentaire=:commentaire where id = :id", nativeQuery = true)
	@Modifying
	@Transactional
	public void commentDocumentAValider(@Param("id")int id,@Param("commentaire")String commentaire);
}
