package fr.pomcompot.runaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Chronometer {
	@Id
	@Column(name = "idChronometer")
	private Integer id;
	
	private Integer chrono;
	
	@ManyToOne
	private Participant participant;
}
