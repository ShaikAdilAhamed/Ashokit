package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.CustomerService;

@RestController
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/customer/{customerId}")
	public String getCustomer(@PathVariable("customerId") Integer customerId) throws Exception {

		String str = customerService.getCustomerNameById(customerId);

		return str;

	}

}
