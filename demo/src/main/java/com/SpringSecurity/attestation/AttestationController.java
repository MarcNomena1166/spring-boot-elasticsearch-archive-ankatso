package com.SpringSecurity.attestation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="attestations")
public class AttestationController {

	
	AttestationService as;
	
	@Autowired
	public AttestationController(AttestationService as) {
		super();
		this.as = as;
	}


	@PostMapping
	public void insertAttestation(@RequestParam("auteur")String auteur,@RequestParam("id")String id)
	{
		String code=this.as.genererCode(auteur);
		
		Attestation att=new Attestation(0, Integer.valueOf(id),code);
		this.as.insertAttestation(att);
		
	}
}
