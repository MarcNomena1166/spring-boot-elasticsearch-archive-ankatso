package com.SpringSecurity.parcour;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Parcour {

	@Id
	int id;
	
	@Column
	String nom_parcour;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_parcour() {
		return nom_parcour;
	}

	public void setNom_parcour(String nom_parcour) {
		this.nom_parcour = nom_parcour;
	}

	public Parcour(int id, String nom_parcour) {
		super();
		this.id = id;
		this.nom_parcour = nom_parcour;
	}

	public Parcour() {
		super();
	}
	
	
}
