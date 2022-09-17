package com.SpringSecurity.document_a_valider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Document_a_valider {

	@Id
	int id;
	@Column
	int id_e;
	@Column
	String nom_pdf;
	@Column
	String statuts;
	@Column
	String commentaire;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_e() {
		return id_e;
	}
	public void setId_e(int id_e) {
		this.id_e = id_e;
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
	public Document_a_valider(int id, int id_e, String nom_pdf, String statuts, String commentaire) {
		super();
		this.id = id;
		this.id_e = id_e;
		this.nom_pdf = nom_pdf;
		this.statuts = statuts;
		this.commentaire = commentaire;
	}
	public Document_a_valider() {
		super();
	}
	
	
	
}
