package fr.pomcompot.runaway.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Gender {
    @Id
    @Column(name = "idGender")
    private Character id;
}
