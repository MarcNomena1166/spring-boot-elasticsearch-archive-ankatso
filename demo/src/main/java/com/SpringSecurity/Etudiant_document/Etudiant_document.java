package com.SpringSecurity.Etudiant_document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Etudiant_document {

	@Id
	int id;
	
	@Column
	String nom;
	@Column
	String prenom;
	@Column
	String email;
	@Column
	String code;
	@Column
	String nom_pdf;
	@Column
	String statuts;
	@Column
	String commentaire;
	public Etudiant_document(int id, String nom, String prenom, String email, String code, String nom_pdf,
			String statuts, String commentaire) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.code = code;
		this.nom_pdf = nom_pdf;
		this.statuts = statuts;
		this.commentaire = commentaire;
	}
	public Etudiant_document() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNom_pdf() {
		return nom_pdf;
	}
	public void setNom_pdf(String nom_pdf) {
		this.nom_pdf = nom_pdf;
	}
	public String getStatuts() {
		return statuts;
	}
	public void setStatuts(String statuts) {
		this.statuts = statuts;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	
}
