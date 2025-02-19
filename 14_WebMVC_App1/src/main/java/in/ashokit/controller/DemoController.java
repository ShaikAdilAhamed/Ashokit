package in.ashokit.controller;

import java.time.LocalDate;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {
	@GetMapping("/currentTime")
	public ModelAndView getTodayDate() {
		ModelAndView mav = new ModelAndView();
		LocalDate curr_Date=LocalDate.now();
		String msgTxt="Today's Date is : "+curr_Date;
		mav.addObject("msg",msgTxt);
		mav.setViewName("index");
		return mav;
	}
}
