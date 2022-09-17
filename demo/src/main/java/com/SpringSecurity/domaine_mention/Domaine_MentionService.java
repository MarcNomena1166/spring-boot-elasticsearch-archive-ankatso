package com.SpringSecurity.domaine_mention;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Domaine_MentionService {

	Domaine_MentionRepository ds;

	@Autowired
	public Domaine_MentionService(Domaine_MentionRepository ds) {
		super();
		this.ds = ds;
	}
	
	public List<Domaine_mention> getListeDomaine_Mention()
	{
		return this.ds.findAll();
	}
}
