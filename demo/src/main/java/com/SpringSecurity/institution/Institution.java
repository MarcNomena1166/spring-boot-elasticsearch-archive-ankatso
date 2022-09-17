package com.SpringSecurity.institution;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Institution {

	@Id
	int id;
	
	@Column
	String nom_institution;
	
	
	public Institution() {
	}
	
	public Institution(int id, String nom_institution) {
		super();
		this.id = id;
		this.nom_institution = nom_institution;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom_institution() {
		return nom_institution;
	}
	public void setNom_institution(String nom_institution) {
		this.nom_institution = nom_institution;
	}
	
	
}
