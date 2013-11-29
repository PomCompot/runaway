package fr.pomcompot.runaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Participant {
    @Id
    @Column(name = "idParticipant")
    private Integer id;

    private Integer bibNumber;

    @ManyToOne
    private Club club;

    @ManyToOne
    private Person person;

    @ManyToOne
    private Edition edition;
}
