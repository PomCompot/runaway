package fr.pomcompot.runaway.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Edition {
    @Id
    @Column(name = "idEdition")
    private Integer id;

    private Date date;

    @ManyToOne
    private Competition competition;

    @ManyToOne
    private Status status;
}
