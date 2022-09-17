package com.SpringSecurity.document_a_valider;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Document_a_validerService {

	Document_a_validerRepository dr;

	@Autowired
	public Document_a_validerService(Document_a_validerRepository dr) {
		super();
		this.dr = dr;
	}
	
	
	public List<Document_a_valider> getDocumentAValider()
	{
		return this.dr.findAll();
	}
	
	public void validerDoc(String id)
	{
		this.dr.updateDocumentAValider(Integer.valueOf(id));
	}

	public void commenterDoc(String id,String commentaire)
	{
		System.out.println("commentaire zandry :"+commentaire);
		System.out.println("id :"+id);
		this.dr.commentDocumentAValider(Integer.valueOf(id), commentaire);
		
	}
	
}
