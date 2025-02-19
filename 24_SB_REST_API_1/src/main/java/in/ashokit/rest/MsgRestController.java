package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {

	public MsgRestController() {
		System.out.println("MsgRestController :: Constructor");
	}

	@GetMapping("/Welcome")
	public ResponseEntity<String> getWelcomeMsg(){
		String msg="WElcome To Ashok It ";
		return new ResponseEntity(msg,HttpStatus.OK);
	}
	
	@GetMapping("/Greet")
	public String getGreetMsg() {
		String msg="Good Evening..!!";
		return msg;
	}
}
