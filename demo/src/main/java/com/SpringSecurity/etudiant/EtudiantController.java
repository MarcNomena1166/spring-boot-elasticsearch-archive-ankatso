package com.SpringSecurity.etudiant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="etudiants")
public class EtudiantController {

	EtudiantService es;
	
	@Autowired
	public EtudiantController(EtudiantService es) {
		this.es = es;
	}


	@GetMapping
	public List<Etudiant> getListeEtudiant()
	{
		return this.es.getListeEtudiant();
	}
}
