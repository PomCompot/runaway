package fr.pomcompot.sample.webapp.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.pomcompot.sample.webapp.entities.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
}
