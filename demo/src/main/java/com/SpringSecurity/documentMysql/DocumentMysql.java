package com.SpringSecurity.documentMysql;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Document")
public class DocumentMysql {

	@Id
	int id;
	
	@Column
	int annee;
	@Column
	String code_Document;
	@Column
	String code_Institution;
	@Column
	String auteur;
	@Column
	String nom_pdf;
	@Column
	int id_institution;
	@Column
	int id_mention;
	@Column
	int id_parcour;
	@Column
	int id_domaine;
	@Column
	int id_sous_discipline;
	@Column
	int id_niveau;
	@Column
	String titre;
	@Column
	String resume;
	@Column
	int visibilite;
	
	public DocumentMysql(int id, int annee, String code_Document, String code_Institution, String auteur,
			String nom_pdf, int id_institution, int id_mention, int id_parcour, int id_domaine, int id_sous_discipline,
			int id_niveau, String titre, String resume, int visibilite) {
		super();
		this.id = id;
		this.annee = annee;
		this.code_Document = code_Document;
		this.code_Institution = code_Institution;
		this.auteur = auteur;
		this.nom_pdf = nom_pdf;
		this.id_institution = id_institution;
		this.id_mention = id_mention;
		this.id_parcour = id_parcour;
		this.id_domaine = id_domaine;
		this.id_sous_discipline = id_sous_discipline;
		this.id_niveau = id_niveau;
		this.titre = titre;
		this.resume = resume;
		this.visibilite = visibilite;
	}

	public DocumentMysql() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getCode_Document() {
		return code_Document;
	}

	public void setCode_Document(String code_Document) {
		this.code_Document = code_Document;
	}

	public String getCode_Institution() {
		return code_Institution;
	}

	public void setCode_Institution(String code_Institution) {
		this.code_Institution = code_Institution;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getNom_pdf() {
		return nom_pdf;
	}

	public void setNom_pdf(String nom_pdf) {
		this.nom_pdf = nom_pdf;
	}

	public int getId_institution() {
		return id_institution;
	}

	public void setId_institution(int id_institution) {
		this.id_institution = id_institution;
	}

	public int getId_mention() {
		return id_mention;
	}

	public void setId_mention(int id_mention) {
		this.id_mention = id_mention;
	}

	public int getId_parcour() {
		return id_parcour;
	}

	public void setId_parcour(int id_parcour) {
		this.id_parcour = id_parcour;
	}

	public int getId_domaine() {
		return id_domaine;
	}

	public void setId_domaine(int id_domaine) {
		this.id_domaine = id_domaine;
	}

	public int getId_sous_discipline() {
		return id_sous_discipline;
	}

	public void setId_sous_discipline(int id_sous_discipline) {
		this.id_sous_discipline = id_sous_discipline;
	}

	public int getId_niveau() {
		return id_niveau;
	}

	public void setId_niveau(int id_niveau) {
		this.id_niveau = id_niveau;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public int getVisibilite() {
		return visibilite;
	}

	public void setVisibilite(int visibilite) {
		this.visibilite = visibilite;
	}
	
	
}




