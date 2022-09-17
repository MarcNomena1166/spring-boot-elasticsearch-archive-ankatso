package com.SpringSecurity.domaine_mention;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.institution.Institution;

@RestController
@RequestMapping(path="domaine_mentions")
public class Domaine_MentionController {

	Domaine_MentionService ds;

	@Autowired
	public Domaine_MentionController(Domaine_MentionService ds) {
		super();
		this.ds = ds;
	}
	
	@GetMapping()
	public List<Domaine_mention> getDomaine_Mention()
	{
		return this.ds.getListeDomaine_Mention();
	}
}
