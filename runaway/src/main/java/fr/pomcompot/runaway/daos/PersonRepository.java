package fr.pomcompot.runaway.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.pomcompot.runaway.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
}
