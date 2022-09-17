package com.SpringSecurity.document;
import org.apache.pdfbox.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(path="documentsES")
public class DocumentController {

	DocumentService ds;
	@Value("${file.upload-dir}")
	String PDF_DIRECTORY;
	

	@Autowired
	public DocumentController(DocumentService ds) {
		super();
		this.ds = ds;
	}

	@PostMapping
	public void insertDocumentES(@RequestParam("auteur")String auteur,@RequestParam("pdf")MultipartFile pdf,
			@RequestParam("id")String id,@RequestParam("mots_cles")String mots_cles,@RequestParam("titre")String titre) 
	{
		
		System.out.println("ito ny auteur ohhh :"+auteur);
		
		try {
	
			String[] npdf=pdf.getOriginalFilename().split("\\.");
	
			File f=new File((PDF_DIRECTORY+auteur+titre+"."+npdf[npdf.length-1]).replaceAll("\\s",""));
			f.createNewFile();
			FileOutputStream fos=new FileOutputStream(f);
			fos.write(pdf.getBytes());
			fos.close();
			
			
			String contenu=this.ds.extractTextPDF(f);	
			System.out.println("isany :"+contenu.length());
			List<String> mocla=this.ds.splitMocla(mots_cles);			
			Document d=new Document( auteur,  contenu, Integer.valueOf(id),  mocla,  titre);		
			this.ds.insertDoc(d);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@GetMapping(path="/find")
	public List<Document> getDocument(@RequestParam("text") String text,@RequestParam("field") String field)
	{
		return this.ds.FilterDocument(text, field);
	}
	
	@PutMapping
	public void updateDocument(@RequestParam("auteur")String auteur,@RequestParam("pdf")MultipartFile pdf,
			@RequestParam("id")String id,@RequestParam("mots_cles")String mots_cles,@RequestParam("titre")String titre)
	{
		try {
			String contenu="";
			String[] npdf=pdf.getOriginalFilename().split("\\.");
	
			if(pdf.isEmpty()==false) {
			File f=new File((PDF_DIRECTORY+auteur+titre+"."+npdf[npdf.length-1]).replaceAll("\\s",""));
			f.createNewFile();
			FileOutputStream fos=new FileOutputStream(f);
			fos.write(pdf.getBytes());
			fos.close();
			
			
			 contenu=this.ds.extractTextPDF(f);
			
			}
			else contenu=this.ds.getDocByid(Integer.valueOf(id)).getContenu();
			//System.out.println("length content: "+contenu.length());
			List<String> mocla=this.ds.splitMocla(mots_cles);			
			Document d=new Document( auteur,  contenu, Integer.valueOf(id),  mocla,  titre);	
			
			this.ds.updateDocumentES(d);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@GetMapping(path="/advfind")
	public int[] advancedFind(@RequestParam("auteur")String auteur,@RequestParam("contenu")String contenu,@RequestParam("titre")String titre)
	{
		return this.ds.getIdListeAdvancedFind(titre, auteur, contenu);
	}
	
	
	
}
