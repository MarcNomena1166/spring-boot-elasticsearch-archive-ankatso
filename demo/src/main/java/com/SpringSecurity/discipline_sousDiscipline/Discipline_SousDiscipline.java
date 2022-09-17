package com.SpringSecurity.discipline_sousDiscipline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Discipline_SousDiscipline {

	@Id
	int id;
	@Column
	int idD;
	@Column
	int idS;
	
	public Discipline_SousDiscipline(int id, int idD, int idS) {
		super();
		this.id = id;
		this.idD = idD;
		this.idS = idS;
	}
	
	public Discipline_SousDiscipline() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdD() {
		return idD;
	}

	public void setIdD(int idD) {
		this.idD = idD;
	}

	public int getIdS() {
		return idS;
	}

	public void setIdS(int idS) {
		this.idS = idS;
	}
	
	
}
