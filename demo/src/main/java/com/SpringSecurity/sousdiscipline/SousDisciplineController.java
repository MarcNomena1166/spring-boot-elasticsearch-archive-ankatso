package com.SpringSecurity.sousdiscipline;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="SousDisciplines")
public class SousDisciplineController {

	SousDisciplineService ss;

	@Autowired
	public SousDisciplineController(SousDisciplineService ss) {
		super();
		this.ss = ss;
	}
	
	@GetMapping()
	public List<SousDiscipline> getParcour()
	{
		return this.ss.getListSousDiscipline();
	}
}
