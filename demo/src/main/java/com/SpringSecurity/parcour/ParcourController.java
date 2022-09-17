package com.SpringSecurity.parcour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.niveau.Niveau;

@RestController
@RequestMapping(path="parcours")
public class ParcourController {

	
	ParcourService ps;
	
	@Autowired
	public ParcourController(ParcourService ps) {
		super();
		this.ps = ps;
	}
	
	@GetMapping()
	public List<Parcour> getParcour()
	{
		return this.ps.getListParcour();
	}
}
