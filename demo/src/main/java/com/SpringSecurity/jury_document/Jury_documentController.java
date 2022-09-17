package com.SpringSecurity.jury_document;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="jury_documents")
public class Jury_documentController {

	Jury_DocumentService js;
	
	
	@Autowired
	public Jury_documentController(Jury_DocumentService js) {
		super();
		this.js = js;
	}



	@PostMapping()
	public void insertJury_Document(@RequestParam("jury")String lj,@RequestParam("idDoc")String idDoc) {
		
		String[] listejury=lj.split("@@@");
		List<Jury_document> j=new ArrayList<Jury_document>();
		System.out.println(lj);
		
	for(int i=0;i<listejury.length;i++) {
			j.add(new Jury_document(0,Integer.valueOf(idDoc),listejury[i]));
			
		}
			
		
		this.js.insertJury(j);
	}
	
	@PutMapping()
	public void updateJury_doc(@RequestParam("jury")String lj,@RequestParam("idDoc")String idDoc)
	{
		
		this.js.deleteJuryDoc(Integer.valueOf(idDoc));
		String[] listejury=lj.split("@@@");
		List<Jury_document> j=new ArrayList<Jury_document>();
		//System.out.println(lj);
		
	for(int i=0;i<listejury.length;i++) {
			j.add(new Jury_document(0,Integer.valueOf(idDoc),listejury[i]));
			
		}
			
		
		this.js.insertJury(j);
	}
}
