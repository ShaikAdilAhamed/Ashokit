package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.User;

@Controller
public class UserController {

	@GetMapping("/")
	public String LoadForm()
	{
		return "index";
	}
	
	@PostMapping("/user")
	public String handleSubmitButton(User user,Model model) {
		
		System.out.println(user);
		model.addAttribute("msg","User Saved");
		
		return "index";
	}
}
