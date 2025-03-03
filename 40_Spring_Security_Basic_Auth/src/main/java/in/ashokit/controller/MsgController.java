package in.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

	@GetMapping("/")
	public String MsgController() {
		return "Hello World";
	}
}
