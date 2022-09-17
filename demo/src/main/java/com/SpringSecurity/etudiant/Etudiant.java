package com.SpringSecurity.etudiant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Etudiant {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String nom;
	String prenom;
	public Etudiant(int id, String nom, String prenom) {
		
		
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Etudiant() {
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
	
	
}
