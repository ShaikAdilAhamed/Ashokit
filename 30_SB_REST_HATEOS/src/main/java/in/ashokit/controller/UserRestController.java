package in.ashokit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import in.ashokit.binding.User;

@RestController
public class UserRestController {

	@GetMapping("/user")
	public ResponseEntity<User> getUser() {
		User user = new User(101, "John", "john@gmail.com");
		
	
		
		//manually adding self relation link(related links)
		
		//for user add i want to add link ("linkTo") that link should be there on method ("methodOn(UserRestController.class)") for method name (".getUser()") with self-relation link ( "withSelfRel()")
		user.add(linkTo(methodOn(UserRestController.class).getUser()).withSelfRel());

		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	
}
