package com.SpringSecurity.document;

import java.util.List;

import javax.persistence.Id;

@org.springframework.data.elasticsearch.annotations.Document(indexName="document")//document ilay d'origine
public class Document {

	
	String auteur;
	String contenu;
	@Id
	int id;
	List<String> mots_cles;
	String titre;
	
	public Document(String auteur, String contenu, int id, List<String> mots_cles, String titre) {
		super();
		this.auteur = auteur;
		this.contenu = contenu;
		this.id = id;
		this.mots_cles = mots_cles;
		this.titre = titre;
	}
	
	public Document() {
		super();
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public String getContenu() {
		return contenu;
	}
	
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public List<String> getMots_cles() {
		return mots_cles;
	}
	
	public void setMots_cles(List<String> mots_cles) {
		this.mots_cles = mots_cles;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	
}
