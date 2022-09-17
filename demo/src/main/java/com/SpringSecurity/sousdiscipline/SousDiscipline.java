package com.SpringSecurity.sousdiscipline;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Sous_discipline")
public class SousDiscipline {

	@Id
	int id;
	@Column
	String nomSousDiscipline;
	
	
	public SousDiscipline() {
		super();
	}
	
	public int getId() {
		return id;
	}
	public SousDiscipline(int id, String nomSousDiscipline) {
		super();
		this.id = id;
		this.nomSousDiscipline = nomSousDiscipline;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomSousDiscipline() {
		return nomSousDiscipline;
	}
	public void setNomSousDiscipline(String nomSousDiscipline) {
		this.nomSousDiscipline = nomSousDiscipline;
	}
	
	
}
