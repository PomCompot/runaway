package fr.pomcompot.runaway.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Performance {
	@Id
	@Column(name = "idPerformance")
	private Integer id;
	
	private Integer score;
	
	private Integer validated;
	
	@ManyToOne
	private Participant participant;
}
