package in.ashokit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

	private Logger logger=LoggerFactory.getLogger(MessageController.class);
	@GetMapping("/welcome")
	public String getWelcomeMsg(Model model)
	{
		logger.info("*********Welcome mssg() execution Started*********");
		model.addAttribute("msg","Welcome to Thymeleaf");
		logger.info("*********Welcome mssg() execution Ended***********");
		
		return "index";
	}
}
