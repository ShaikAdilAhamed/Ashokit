package in.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@GetMapping(value = "/admin")
	public String admin() {
		
		return  "<h3>Welcome admin </h3>";
	}
	
	@GetMapping(value = "/user")
	public String user() {
		
		return  "<h3>Welcome User </h3>";
	}
	
	@GetMapping(value = "/")
	public String welcome() {
		
		return  "<h3>Welcome </h3>";
	}
	
}
