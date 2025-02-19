package in.ashikit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class carController {
//http://localhost:8080/car/123/hyd
	@GetMapping("/car/{carId}/hyd")
	public ModelAndView getCarColor(@PathVariable Integer carId) {
		ModelAndView view = new ModelAndView();
		String color = null;
		if (carId >= 100) {
			color = "red";
		} else {
			color = "black";
		}

		view.addObject("msg", "Car color is : " + color);
		view.setViewName("index");
		return view;
	}

	// http://localhost:8080/stock/BMW/location/kdp/congrats
	@GetMapping("/stock/{brand}/location/{loc}/congrats")
	public ModelAndView getCarStock(@PathVariable String brand, @PathVariable String loc) {
		ModelAndView view = new ModelAndView();

		view.addObject("msg", "Car Brand is " + brand + " car location is " + loc);
		view.setViewName("index");
		return view;
	}
}
