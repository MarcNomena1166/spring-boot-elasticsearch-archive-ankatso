package com.SpringSecurity.documentMysql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.SpringSecurity.document.Document;

@Service
public class DocumentMysqlService {

	DocumentMysqlRepository dr;

	@Autowired
	public DocumentMysqlService(DocumentMysqlRepository dr) {
		super();
		this.dr = dr;
	}
	
	public void deleteDoc(int id)
	{
		this.dr.deleteById(id);
	}
	
	public int insertDocumentMysql(DocumentMysql doc) {
		this.dr.save(doc);
		return this.dr.getMaxid();
	}
	
	public DocumentMysql findById(int id)
	{
		return this.dr.findWithId(id);
	}
	public List<DocumentMysql> getDocuments()
	{	 
		 return this.dr.findAll();
		
	}
	
	public List<DocumentMysql> advancedFind(int[] id,String idI,String idD,String idM)
	{
		System.out.println(" idI :"+idI+" idD :"+idD+" idM :"+idM);
		List<DocumentMysql> retour=new ArrayList<DocumentMysql>();
		int score=0;
		for(int i=0;i<id.length;i++)
		{
			DocumentMysql temp=this.dr.findById(id[i]).get();
			
			if(!idI.isBlank() && Integer.valueOf(idI)==temp.getId_institution())score++;
			if(idI.isBlank())score++;
			System.out.println(" score 1:"+score);
			
			if(!idD.isBlank() && Integer.valueOf(idD)==temp.getId_domaine())score++;
			if(idD.isBlank())score++;
			System.out.println(" score 2:"+score);
			
			if(!idM.isBlank() && Integer.valueOf(idM)==temp.getId_mention())score++;
			if(idM.isBlank())score++;
			System.out.println(" score 3:"+score);
			
			if(score==3)retour.add(temp);
			System.out.println(" id :"+id[i]);
			
				score=0;
		}

		return retour;
	}
	
	public String buildQuery(String idI,String idD,String idM,int id)
	{
		String retour="SELECT * FROM Document where ";
		if(idI.isBlank())retour=retour+"id_institution="+Integer.valueOf(idI)+" and ";
		if(!idD.isBlank())retour=retour+"id_domaine="+Integer.valueOf(idD)+" and ";
		if(!idM.isBlank())retour=retour+"id_mention="+Integer.valueOf(idM)+" and ";
		retour=retour+"id="+id;
		System.out.println(retour);
		return retour;
	}
	
	
	public void updateDocumentMysql(DocumentMysql doc)
	{
		this.dr.updateDocumentMysql(doc.getId(), doc.getAnnee(), doc.getCode_Document(), doc.getCode_Institution(), doc.getAuteur(),
				doc.getNom_pdf(),doc.getId_institution(), doc.getId_mention(),doc.getId_parcour(),doc.getId_domaine(), doc.getId_sous_discipline(), doc.getId_niveau(), 
				doc.getTitre(), doc.getResume(), doc.getVisibilite());
	}
	
	public Example<DocumentMysql> buildClass(String idI,String idD,String idM,int id)
	{
		DocumentMysql doc=new DocumentMysql();
		doc.setId(id);
	//	if(!idD.isBlank())doc.setId_domaine(Integer.valueOf(idD));
	//	if(!idI.isBlank())doc.setId_institution(Integer.valueOf(idI));
	//	if(!idM.isBlank())doc.setId_mention(Integer.valueOf(idM));
		
		return Example.of(doc);
	}
	
	
}
