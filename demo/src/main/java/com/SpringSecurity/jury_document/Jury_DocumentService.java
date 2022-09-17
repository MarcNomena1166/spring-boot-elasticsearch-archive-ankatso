package com.SpringSecurity.jury_document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Jury_DocumentService {

	Jury_DocumentRepository jr;

	@Autowired
	public Jury_DocumentService(Jury_DocumentRepository jr) {
		super();
		this.jr = jr;
	}
	
	public void deleteJuryDoc(int idDoc)
	{
		this.jr.deleteJuryDocByIdDoc(idDoc);
	}
	
	public void insertJury(List<Jury_document> ljd)
	{
	
		for(int i=0;i<ljd.size();i++)		
		{

			Jury_document jd=ljd.get(i);
			System.out.println("insert jury babyyyyy :"+jd.getNom_jury());
			this.jr.save(jd);
		}
			
	}
	
	public void updateJuryDoc(List<Jury_document> ljd)
	{
		this.deleteJuryDoc(ljd.get(0).getId_d());
		this.insertJury(ljd);
	}
}
