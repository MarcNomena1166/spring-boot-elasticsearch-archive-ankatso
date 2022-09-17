package com.SpringSecurity.discipline_sousDiscipline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Discipline_SousDisciplineService {

	
	Discipline_SousDisciplineRepository sdr;

	@Autowired
	public Discipline_SousDisciplineService(Discipline_SousDisciplineRepository sdr) {
		super();
		this.sdr = sdr;
	}
	
	public List<Discipline_SousDiscipline> getListDiscipline_SousDiscipline()
	{
		return this.sdr.findAll();
	}
}
