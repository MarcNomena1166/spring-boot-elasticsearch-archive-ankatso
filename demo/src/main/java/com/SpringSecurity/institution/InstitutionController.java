package com.SpringSecurity.institution;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.domaine.Domaine;

@RestController
@RequestMapping(path="institutions")
public class InstitutionController {

	
	InstitutionService is;

	@Autowired
	public InstitutionController(InstitutionService is) {
		super();
		this.is = is;
	}
	
	@GetMapping()
	public List<Institution> getInstitution()
	{
		return this.is.getListInstitution();
	}
}
