package in.ashokit.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class DemoController {
	 @GetMapping("/demo")
	    @ResponseBody
	    public String getGreetMsg() {
	        String msg = "Good Evening";
	        String str = null;
	        str.length();  // This will cause a NullPointerException
	        return msg;
	    }

}
