package com.SpringSecurity.attestation;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttestationRepository extends JpaRepository<Attestation,Integer>{


	@Query(value = "DELETE FROM attestation WHERE attestation.id_d = :idDoc", nativeQuery = true)
	@Modifying
	@Transactional
	public void deleteAttestationByIdDoc(@Param("idDoc") int idDoc);
}
