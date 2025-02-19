package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class MessageController {

	@GetMapping("/welcome")

	public String welcomeMsg() {
		System.out.println("welcome method");
		return "Welcome to Ashok IT";
	}

	@GetMapping("/greet")
	public String greetMsg() {

		return "Good evening";
	}

}
