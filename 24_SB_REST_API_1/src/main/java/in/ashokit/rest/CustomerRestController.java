package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.Customer;

@RestController
public class CustomerRestController {
	//we process data  and send (response) to client in xml or json 
	//"produces" entity : it "creates" data in 2 format xml or json format
	@GetMapping(value = "/customer" ,produces = {"application/xml","application/json"} )
	public Customer getCustomer() {
		
		Customer c=new Customer();
		c.setName("Adil");
		c.setEmail("Adil@gmail.com");
		c.setGender("Male");
		
		return c;
	}
	
	//client gives data (Request) in xml or json  we accept that and process 
	//"consumes" entity : it "accepts" data in 2 format xml or json format
	//after consuming we proceess and gives response data in (plain text)
	@PostMapping(value = "/customer",consumes = {"application/xml","application/json"}, produces = {"text/plain"})
	//(@RequestBody)it is use to binds the body that (postman we add the body) and stores into Customer object  
	public ResponseEntity<String> addCustomer(@RequestBody Customer customer)
	{
		System.out.println(customer);
		
		return new ResponseEntity("Customer saved",HttpStatus.CREATED);
	}
	
}
