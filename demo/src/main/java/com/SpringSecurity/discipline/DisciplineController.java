package com.SpringSecurity.discipline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.sousdiscipline.SousDiscipline;

@RestController
@RequestMapping(path="disciplines")
public class DisciplineController {

	
	DisciplineService ds;

	@Autowired
	public DisciplineController(DisciplineService ds) {
		super();
		this.ds = ds;
	}
	
	@GetMapping()
	public List<Discipline> getDiscipline()
	{
		return this.ds.getListeDiscipline();
	}
}
