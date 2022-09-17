package com.SpringSecurity.domaine_mention;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Domaine_mention {

	@Id
	int id;
	
	@Column
	int idD;
	
	
	@Column
	int idM;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Domaine_mention(int id, int idD, int idM) {
		super();
		this.id = id;
		this.idD = idD;
		this.idM = idM;
	}

	public Domaine_mention() {
		super();
	}

	public int getIdD() {
		return idD;
	}

	public void setIdD(int idD) {
		this.idD = idD;
	}

	public int getIdM() {
		return idM;
	}

	public void setIdM(int idM) {
		this.idM = idM;
	}
	
	
	
	
}
