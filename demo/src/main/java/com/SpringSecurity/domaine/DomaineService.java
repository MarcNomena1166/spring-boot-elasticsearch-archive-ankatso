package com.SpringSecurity.domaine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomaineService {

	DomaineRepository dr;

	@Autowired
	public DomaineService(DomaineRepository dr) {
		super();
		this.dr = dr;
	}
	
	public List<Domaine> getListDomaine()
	{
		return this.dr.findAll();
	}
}
