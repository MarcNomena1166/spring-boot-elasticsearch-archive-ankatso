package com.SpringSecurity.discipline_sousDiscipline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.sousdiscipline.SousDiscipline;

@RestController
@RequestMapping(path="Discipline_SousDisciplines")
public class Discipline_SousDisciplineController {

	Discipline_SousDisciplineService ds;
	
	
	@Autowired
	public Discipline_SousDisciplineController(Discipline_SousDisciplineService ds) {
		super();
		this.ds = ds;
	}



	@GetMapping()
	public List<Discipline_SousDiscipline> getParcour()
	{
		return this.ds.getListDiscipline_SousDiscipline();
	}
}
