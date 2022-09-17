package com.SpringSecurity.niveau;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Niveau {

	@Id
	int id;
	
	@Column
	String nom_niveau;
	
	
	public Niveau() {
		super();
	}
	
	public Niveau(int id, String nom_niveau) {
		super();
		this.id = id;
		this.nom_niveau = nom_niveau;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_niveau() {
		return nom_niveau;
	}
	public void setNom_niveau(String nom_niveau) {
		this.nom_niveau = nom_niveau;
	}
	
	
}
