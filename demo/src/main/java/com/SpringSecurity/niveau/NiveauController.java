package com.SpringSecurity.niveau;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.mention.Mention;

@RestController
@RequestMapping(path="niveaux")
public class NiveauController {

	
	NiveauService ns;
	
	@Autowired
	public NiveauController(NiveauService ns) {
		super();
		this.ns = ns;
	}
	
	@GetMapping()
	public List<Niveau> getNiveau()
	{
		return this.ns.getListNiveau();
	}
}
