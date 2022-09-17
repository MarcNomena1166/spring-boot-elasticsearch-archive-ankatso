package com.SpringSecurity.mention;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentionService {

	MentionRepository mr;

	@Autowired
	public MentionService(MentionRepository mr) {
		super();
		this.mr = mr;
	}
	
	public List<Mention> getListMention(){
		
		return this.mr.findAll();
	}
	
	
}
