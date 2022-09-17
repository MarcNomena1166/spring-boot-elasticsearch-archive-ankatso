package com.SpringSecurity.attestation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Attestation {

	@Id
	int id;
	
	@Column
	int Id_d;
	
	@Column
	String code;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_d() {
		return Id_d;
	}

	public void setId_d(int id_d) {
		Id_d = id_d;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Attestation(int id, int id_d, String code) {
		super();
		this.id = id;
		Id_d = id_d;
		this.code = code;
	}

	public Attestation() {
		super();
	}

	
	
	
}
