package com.SpringSecurity.etudiant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtudiantService {

	EtudiantRepository er;
	
	@Autowired
	public EtudiantService(EtudiantRepository er) {
		super();
		this.er = er;
	}


	public List<Etudiant> getListeEtudiant()
	{
		
		return er.findAll();
	}
}
