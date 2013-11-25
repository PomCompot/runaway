package fr.pomcompot.runaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Club {
    @Id
    @Column(name = "idClub")
    private Integer id;

    private String name;
}
