package com.SpringSecurity.jury_document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Jury_document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	int id_d;
	@Column
	String nom_jury;
	
	public Jury_document(int id, int idD, String nom_jury) {
		super();
		this.id = id;
		this.id_d = idD;
		this.nom_jury = nom_jury;
	}

	public Jury_document() {
		super();
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_d() {
		return id_d;
	}

	public void setId_d(int id_d) {
		this.id_d = id_d;
	}

	public String getNom_jury() {
		return nom_jury;
	}

	public void setNom_jury(String nom_jury) {
		this.nom_jury = nom_jury;
	}
	
	
	
	
}
