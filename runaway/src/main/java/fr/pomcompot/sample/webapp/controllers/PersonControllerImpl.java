package fr.pomcompot.sample.webapp.controllers;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pomcompot.sample.webapp.daos.PersonRepository;
import fr.pomcompot.sample.webapp.entities.Person;

@Controller
public class PersonControllerImpl implements PersonController {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Resource
	private PersonRepository personRepository;

	@Override
	public String hello() {
		return "Say what you want.";
	}
	
	@Transactional(readOnly = true)
	@Override
	public @ResponseBody Iterable<Person> list() {
		return personRepository.findAll();
	}
}
