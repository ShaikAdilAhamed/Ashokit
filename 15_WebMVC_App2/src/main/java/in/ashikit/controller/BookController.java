package in.ashikit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {

	//localhost:8080/msg?name=Adil
	@GetMapping("/msg")
	public ModelAndView getMsg(@RequestParam String name)
	{
		String msgTxt = name+", Good Evening";
		ModelAndView mav= new ModelAndView();
		System.out.println(msgTxt);
		mav.addObject("msg",msgTxt);
		mav.setViewName("index");
		return mav;
	}
	
	//localhost:8080/book?name=spring&author=johnson
	@GetMapping("/book")
	public ModelAndView getMsg(@RequestParam String name,String author)
	{
		
		System.out.println("name :: "+name );
		System.out.println("author ::"+author);
		
		ModelAndView mav= new ModelAndView();
		//System.out.println(msgTxt);
		mav.addObject("msg",name+" By "+author+" Book is out of stock");
		mav.setViewName("index");
		return mav;
	}
}
