package fr.pomcompot.sample.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pomcompot.sample.webapp.entities.Person;

@Controller
@RequestMapping("/person")
public interface PersonController {

	@RequestMapping("/list")
	public abstract @ResponseBody Iterable<Person> list();

	@RequestMapping("/hello")
	public abstract @ResponseBody String hello();

}