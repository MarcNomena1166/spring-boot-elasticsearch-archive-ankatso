package com.SpringSecurity.parcour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcourService {

	ParcourRepository pr;

	@Autowired
	public ParcourService(ParcourRepository pr) {
		super();
		this.pr = pr;
	}
	
	public List<Parcour> getListParcour()
	{
		return this.pr.findAll();
	}
}
