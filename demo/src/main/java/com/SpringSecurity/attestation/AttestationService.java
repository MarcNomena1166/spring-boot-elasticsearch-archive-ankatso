package com.SpringSecurity.attestation;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttestationService {

	AttestationRepository ar;

	@Autowired
	public AttestationService(AttestationRepository ar) {
		super();
		this.ar = ar;
	}
	
	public void insertAttestation(Attestation a)
	{
		this.ar.save(a);
		
	}
	
	public void deleteAttestation(int idDoc)
	{
		this.ar.deleteAttestationByIdDoc(idDoc);
	}
	
	public String genererCode(String auteur)
	{
		Random rand = new Random();
		String alphabet = "qwertyuiopasdfghjklzxcvbnm12345678901235";
		String code="";
		System.out.println("inty ilay code "+code);
		int longueur = alphabet.length();
		for(int i = 0; i < 10; i++) 
			{
				 int k = rand.nextInt(longueur);
				 code=code+alphabet.charAt(k);
			}
		return code;
		 
	}
}
