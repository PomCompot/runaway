package fr.pomcompot.sample.webapp.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Person {
	@Id
	private String id;
	
    private String firstname, lastname;
    
    private Date birthDate;
    
    @Enumerated(EnumType.STRING)
    private Gender gender;
}
