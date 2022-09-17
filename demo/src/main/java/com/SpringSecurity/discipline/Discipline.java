package com.SpringSecurity.discipline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Discipline {

	@Id
	int id;
	
	@Column
	String nomDiscipline;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomDiscipline() {
		return nomDiscipline;
	}

	public void setNomDiscipline(String nomDiscipline) {
		this.nomDiscipline = nomDiscipline;
	}

	public Discipline(int id, String nomDiscipline) {
		super();
		this.id = id;
		this.nomDiscipline = nomDiscipline;
	}

	public Discipline() {
		super();
	}
	
	
}
