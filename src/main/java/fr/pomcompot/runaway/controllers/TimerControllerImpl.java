package fr.pomcompot.runaway.controllers;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.pomcompot.runaway.timer.Timer;

@Controller
@Named
@RequestMapping("/timer")
public class TimerControllerImpl implements TimerController {
	private final static Logger LOGGER = LoggerFactory.getLogger(TimerControllerImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Inject
	private Timer timer;
	
	@Override
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	public @ResponseBody Boolean start(Long time) {
		timer.reset();
		return true;
	}

	@Override
	@RequestMapping(value = "/tick", method = RequestMethod.PUT)
	public @ResponseBody Long tick(Long time, String number) {
		long elapsedTime = timer.getElapsedTime();
		LOGGER.info("Real elapsed time: {}ms", elapsedTime);
		return elapsedTime;
	}

	@Override
	@RequestMapping(value = "/stop", method = RequestMethod.POST)
	public @ResponseBody Boolean stop() {
		return true;
	}
}
