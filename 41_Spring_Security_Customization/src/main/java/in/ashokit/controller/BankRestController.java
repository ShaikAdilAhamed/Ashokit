package in.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {

	@GetMapping("/balance")
	public String balance() {

		return "Your balance :: 7898.90 INR";
	}

	@GetMapping("/transfer")
	public String amtransfer() {

		return "Your amount transfer successfully.";
	}

	@GetMapping("/login-check")
	public String login() {

		return "Your Login Success";
	}

	@GetMapping("/contact")
	public String getContactInfo() {
		
		return "Contact Us :: abc@bank.com";
	}
}
