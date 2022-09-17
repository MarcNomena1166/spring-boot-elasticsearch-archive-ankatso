package com.SpringSecurity.mention;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Mention {

	@Id
	int id;
	
	@Column
	String nom_mention;

	public Mention(int id, String nom_mention) {
		super();
		this.id = id;
		this.nom_mention = nom_mention;
	}

	public Mention() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_mention() {
		return nom_mention;
	}

	public void setNom_mention(String nom_mention) {
		this.nom_mention = nom_mention;
	}
	
	
	
}
