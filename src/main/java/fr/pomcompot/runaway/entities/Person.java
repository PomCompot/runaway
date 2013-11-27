package fr.pomcompot.runaway.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Person {
    @Id
    @Column(name = "idPerson")
    private Integer id;

    @Column(nullable = false)
    private String firstname, lastname;

    private Date birthDate;

    @ManyToOne
    private Gender gender;

    @ManyToOne
    private City city;
}
