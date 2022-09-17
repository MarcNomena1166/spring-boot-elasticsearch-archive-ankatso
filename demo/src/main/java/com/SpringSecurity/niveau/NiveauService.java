package com.SpringSecurity.niveau;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NiveauService {

	NiveauRepository nr;

	@Autowired
	public NiveauService(NiveauRepository nr) {
		super();
		this.nr = nr;
	}
	
	public List<Niveau> getListNiveau()
	{
		return this.nr.findAll();
	}
}
