package com.SpringSecurity.domaine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.document.Document;

@RestController
@RequestMapping(path="domaines")
public class DomaineController {
	
	DomaineService ds;
	
	
	@Autowired
	public DomaineController(DomaineService ds) {
		super();
		this.ds = ds;
	}



	@GetMapping()
	public List<Domaine> getDocument()
	{
		return this.ds.getListDomaine();
	}
}
