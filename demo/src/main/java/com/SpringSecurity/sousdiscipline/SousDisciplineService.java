package com.SpringSecurity.sousdiscipline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.SpringSecurity.parcour.Parcour;

@Service
public class SousDisciplineService {

	SousDisciplineRepository sr;

	@Autowired
	public SousDisciplineService(SousDisciplineRepository sr) {
		super();
		this.sr = sr;
	}
	
	public List<SousDiscipline> getListSousDiscipline()
	{
		return this.sr.findAll();
	}
	

}
