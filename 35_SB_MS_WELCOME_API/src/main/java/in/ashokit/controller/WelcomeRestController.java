package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.GreetFeignClient;

@RestController
public class WelcomeRestController {

	@Autowired
	private  GreetFeignClient greetFeignClient;
	
	//getting data from global environment we will be setting port there 
		//runninig multiple instances of one project
		//steps
		/*
		 * right click on project  > select your project > In (Arguments) section > in ( VM arguments ) section > add this (-Dserver.port=9091)
		 *                                                                                                                  -D means run time argument                                                               
		 */
	
	@Autowired
	private Environment env;
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		//In which server our app is running, get that server port number
		String port = env.getProperty("server.port");
		String welcomeMsg="Welcome to Ashok IT ( "+port+" )";
		String greetmssg= greetFeignClient.invokGreetApi();
		return greetmssg+" , "+welcomeMsg;
	}
}
