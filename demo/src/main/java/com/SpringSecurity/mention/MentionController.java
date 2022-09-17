package com.SpringSecurity.mention;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.domaine.Domaine;

@RestController
@RequestMapping(path="mentions")
public class MentionController {

	
	MentionService ms;

	@Autowired
	public MentionController(MentionService ms) {
		super();
		this.ms = ms;
	}
	
	@GetMapping()
	public List<Mention> getMention()
	{
		return this.ms.getListMention();
	}
	
}
