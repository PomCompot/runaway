package fr.pomcompot.runaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Rank {
	@Id
	@Column(name = "idRank")
	private Integer id;
	
	private Integer rank;
	
	@ManyToOne
	private Participant participant;
}
