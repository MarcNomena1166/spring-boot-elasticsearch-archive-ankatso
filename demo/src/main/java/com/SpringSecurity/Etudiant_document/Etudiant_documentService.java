package com.SpringSecurity.Etudiant_document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Etudiant_documentService {

	Etudiant_documentRepository er;

	@Autowired
	public Etudiant_documentService(Etudiant_documentRepository er) {
		super();
		this.er = er;
	}
	
	
	public List<Etudiant_document> getEtudiantDocument()
	{
		return this.er.findAll();
	}
//	public Etudiant_document getEtudiantDocumentById(String id)
//	{
//		this.er.findById(Integer.valueOf(id)).get();
//	}
}
