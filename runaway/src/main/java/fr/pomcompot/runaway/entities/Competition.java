package fr.pomcompot.runaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Competition {
    @Id
    @Column(name = "idCompetition")
    private Integer id;

    private String name;
}
