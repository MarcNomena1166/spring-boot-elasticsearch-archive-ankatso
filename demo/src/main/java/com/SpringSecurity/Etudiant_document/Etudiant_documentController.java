package com.SpringSecurity.Etudiant_document;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="etudiantDocuments")
public class Etudiant_documentController {

	Etudiant_documentService es;
	
	@Value("${file.download-dir}")
	String PDF_VALIDER_DIRECTORY;
	
	@Autowired
	public Etudiant_documentController(Etudiant_documentService es) {
		super();
		this.es = es;
	}
	
	@GetMapping
	public List<Etudiant_document> getListDocumentNonValide(){
		return this.es.getEtudiantDocument();
	}
	
	@GetMapping(path="/{id}")
	public File downloadFileDocument(@PathVariable("id") String id)
	{
		return null;
	}
}
