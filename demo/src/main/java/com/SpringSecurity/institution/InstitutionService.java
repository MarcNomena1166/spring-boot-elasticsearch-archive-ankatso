package com.SpringSecurity.institution;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {

	InstitutionRepository ir;

	
	@Autowired
	public InstitutionService(InstitutionRepository ir) {
		super();
		this.ir = ir;
	}
	
	public List<Institution> getListInstitution()
	{
		return this.ir.findAll();
				
	}
	
}
