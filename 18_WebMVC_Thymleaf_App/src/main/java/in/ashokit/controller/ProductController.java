package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.binding.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;

@Controller
public class ProductController {

	//method to display
	
	@GetMapping("/")
	private String loadForm(Model model) {
	    model.addAttribute("product", new Product());
	    return "index";
	}

	//method to save
	
	//( @Valid ) annotation it is use to trigger for ( @notnull, @Size(min = 3, max = 8) ) annotions which are there in product.java class
	//( Bindingresult ) interface if any errors cames use can handle using this like
	//ex: we use in if condition if(bindingResult.hasErrors())
	@PostMapping("/pro")
	public String handleSubmitBtn(@Valid Product p,BindingResult bindingResult, Model model)
	{
		if(bindingResult.hasErrors())
		{
			return "index";
		}else {
		System.out.println(p);
		model.addAttribute("msg","product saved");
		return "index";
		}
	}
}
