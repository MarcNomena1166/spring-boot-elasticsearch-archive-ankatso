package com.SpringSecurity.domaine;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Domaine")
public class Domaine {
	
		@Id
		int	id;
		
		@Column(name="nom_domaine")
		String nom_domaine;
		
		public Domaine(int id, String nom_domaine) {
			super();
			this.id = id;
			this.nom_domaine = nom_domaine;
		}
		
		public Domaine() {
			
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNom_domaine() {
			return nom_domaine;
		}

		public void setNom_domaine(String nom_domaine) {
			this.nom_domaine = nom_domaine;
		}


		
		
}
