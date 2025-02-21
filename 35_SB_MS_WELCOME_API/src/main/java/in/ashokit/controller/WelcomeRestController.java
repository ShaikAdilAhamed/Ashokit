package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.GreetFeignClient;

@RestController
public class WelcomeRestController {

	@Autowired
	private  GreetFeignClient greetFeignClient;
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String welcomeMsg="Welcome to Ashok IT ";
		String greetmssg= greetFeignClient.invokGreetApi();
		return greetmssg+" , "+welcomeMsg;
	}
}
