package com.SpringSecurity.discipline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {

	DisciplineRepository dr;

	@Autowired
	public DisciplineService(DisciplineRepository dr) {
		super();
		this.dr = dr;
	}
	
	
	public List<Discipline> getListeDiscipline(){
		return this.dr.findAll();
	}
	
}
