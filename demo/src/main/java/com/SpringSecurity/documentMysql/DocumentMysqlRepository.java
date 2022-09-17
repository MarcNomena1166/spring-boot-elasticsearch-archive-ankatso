package com.SpringSecurity.documentMysql;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentMysqlRepository extends JpaRepository<DocumentMysql,Integer>{

	@Query(value = "SELECT max(id) FROM document", nativeQuery = true)
	public int getMaxid() ;
	
	@Query(value = "update document set annee= :a,code_document= :cd,"
			+ "code_institution= :ci,auteur=:auteur,nom_pdf=:npdf,id_institution=:id_i,"
			+ "ïd_mention=:id_m,id_parcour=:id_p,id_domaine=:id_d,id_sous_discipline=:id_sd,id_niveau=:id_n,"
			+ "titre=:t,resume=:r,visibilite=:v where id=:idDoc", nativeQuery = true)
	@Modifying
	@Transactional
	public void updateDocumentMysql(@Param("idDoc") int idDoc,@Param("a") int a,@Param("cd") String cd,@Param("ci") String ci,@Param("auteur") String auteur,
			@Param("npdf") String npdf,@Param("id_i") int id_i,@Param("id_m") int id_m,@Param("id_p") int id_p,@Param("id_d") int id_d,@Param("id_sd") int id_sd,
			@Param("id_n") int id_n,@Param("t") String t,@Param("r") String r,@Param("v") int v);
	
	@Query(value = "select * from document where id=:id", nativeQuery = true)
	public DocumentMysql findWithId(@Param("id") int id);
	
	@Query(value = ":quest", nativeQuery = true)
	public DocumentMysql advancedFind(@Param("quest")String query);
	
	
	


}
