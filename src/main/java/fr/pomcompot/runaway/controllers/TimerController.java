package fr.pomcompot.runaway.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/timer")
public interface TimerController {
	@RequestMapping(value = "/start", method = RequestMethod.POST)
	@ResponseBody Boolean start(Long time);
	
	@RequestMapping(value = "/tick", method = RequestMethod.PUT)
	@ResponseBody Long tick(Long time, String number);
	
	@RequestMapping(value = "/stop", method = RequestMethod.POST)
	@ResponseBody Boolean stop();
}
