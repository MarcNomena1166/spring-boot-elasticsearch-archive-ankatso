package com.SpringSecurity.documentMysql;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.SpringSecurity.attestation.Attestation;
import com.SpringSecurity.attestation.AttestationService;
import com.SpringSecurity.document.Document;
import com.SpringSecurity.document.DocumentService;
import com.SpringSecurity.jury_document.Jury_DocumentService;


@RestController
@RequestMapping(path="documentsMysql")
public class DocumentMysqlController {

	DocumentMysqlService ds;
	
	@Autowired
	AttestationService as;
	
	@Autowired
	DocumentService dess;
	
	@Autowired
	Jury_DocumentService js;
	
	@Value("${file.upload-dir}")
	String PDF_DIRECTORY;
	
	@Autowired
	public DocumentMysqlController(DocumentMysqlService ds) {
		super();
		this.ds = ds;
	}



	@PostMapping()
	public int insertDocument(@RequestParam("annee")String annee,@RequestParam("codeInstitution")String codeInstitution
			,@RequestParam("auteur")String auteur,@RequestParam("directeur")String directeur,@RequestParam("titre")String titre,@RequestParam("dateSoutenance")String dateSoutenance,
			@RequestParam("institution")String institution,@RequestParam("codeDocument")String codeDocument,@RequestParam("jury")List jury
			,@RequestParam("resume")String resume,@RequestParam("niveau")String niveau,@RequestParam("domaine")String domaine
			,@RequestParam("mention")String mention,@RequestParam("parcour")String parcour,@RequestParam("sousDiscipline")String sousDiscipline
			,@RequestParam("visibilite")String visibilite)
			{
				
			DocumentMysql doc=new DocumentMysql();
				doc.setAnnee(Integer.valueOf(annee));
				doc.setAuteur(auteur);
				doc.setCode_Document(codeDocument);
				doc.setCode_Institution(codeInstitution);
				doc.setId(0);
				doc.setId_domaine(Integer.valueOf(domaine));
				doc.setId_institution(Integer.valueOf(institution));
				doc.setId_mention(Integer.valueOf(mention));
				doc.setId_niveau(Integer.valueOf(niveau));
				doc.setId_parcour(Integer.valueOf(parcour));
				doc.setId_sous_discipline(Integer.valueOf(sousDiscipline));
				doc.setResume(resume);
				doc.setNom_pdf((auteur+titre).replaceAll("\\s",""));
				doc.setTitre(titre);
				doc.setVisibilite(Integer.valueOf(visibilite));
				
				int d=this.ds.insertDocumentMysql(doc);
				
				String code=this.as.genererCode(auteur);
				
				Attestation att=new Attestation(0,d,code);
				this.as.insertAttestation(att);
				
				
				
				return d;				
			}
	
			@GetMapping
			public List<DocumentMysql> getListeDocument()
			{
				return this.ds.getDocuments();
			}
			
			@DeleteMapping(path="/{id}")
			public void deleteDoc(@PathVariable("id")String id)
			{
				try {
				int finalId=Integer.valueOf(id);
				System.out.println("test 1:ES");
				
				this.dess.deleteDoc(finalId);
				System.out.println("test 2:Attestation");
				this.as.deleteAttestation(finalId);
				System.out.println("test 3:jury");
				this.js.deleteJuryDoc(finalId);
				
				
				DocumentMysql dm=this.ds.findById(finalId);
				System.out.println("test 4:doc");
				this.ds.deleteDoc(finalId);
				
				File myFile = new File(PDF_DIRECTORY+dm.getNom_pdf()+".pdf"); 
				myFile.delete();
				}catch(Exception e)
				{
					System.out.println(""+e.getMessage());
					e.printStackTrace();
				}
				
			}
			
			@PutMapping()
			public void updateDocument(@RequestParam("annee")String annee,@RequestParam("codeInstitution")String codeInstitution
					,@RequestParam("auteur")String auteur,@RequestParam("directeur")String directeur,@RequestParam("titre")String titre,@RequestParam("dateSoutenance")String dateSoutenance,
					@RequestParam("institution")String institution,@RequestParam("codeDocument")String codeDocument,@RequestParam("jury")List jury
					,@RequestParam("resume")String resume,@RequestParam("niveau")String niveau,@RequestParam("domaine")String domaine
					,@RequestParam("mention")String mention,@RequestParam("parcour")String parcour,@RequestParam("sousDiscipline")String sousDiscipline
					,@RequestParam("visibilite")String visibilite,@RequestParam("idDoc")String id)
					{
						
					DocumentMysql doc=new DocumentMysql();
						doc.setAnnee(Integer.valueOf(annee));
						doc.setAuteur(auteur);
						doc.setCode_Document(codeDocument);
						doc.setCode_Institution(codeInstitution);
						doc.setId(Integer.valueOf(id));
						doc.setId_domaine(Integer.valueOf(domaine));
						doc.setId_institution(Integer.valueOf(institution));
						doc.setId_mention(Integer.valueOf(mention));
						doc.setId_niveau(Integer.valueOf(niveau));
						doc.setId_parcour(Integer.valueOf(parcour));
						doc.setId_sous_discipline(Integer.valueOf(sousDiscipline));
						doc.setResume(resume);
						doc.setNom_pdf((auteur+titre).replaceAll("\\s",""));
						doc.setTitre(titre);
						doc.setVisibilite(Integer.valueOf(visibilite));
						
						ds.updateDocumentMysql(doc);
						
					}
			@GetMapping(path="/find")
			public List<DocumentMysql> advancedFind(@RequestParam("idD")String idD,@RequestParam("idM")String idM,@RequestParam("idI")String idI,
					@RequestParam("titre")String titre,@RequestParam("auteur")String auteur,@RequestParam("contenu")String contenu)
			{
				int[] listeId=	this.dess.getIdListeAdvancedFind(titre, auteur, contenu);
				return this.ds.advancedFind(listeId, idI, idD, idM);
			}
			
			
}
