package in.ashokit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {

    @GetMapping("/welcome")
    @ResponseBody
    public String getWelcomeMsg() {
        String msg = "Welcome to Ashok It";
        int i = 10 / 0;  // This will cause an ArithmeticException
        return msg;
    }

    @GetMapping("/greet")
    @ResponseBody
    public String getGreetMsg() {
        String msg = "Good Evening";
        String str = null;
        str.length();  // This will cause a NullPointerException
        return msg;
    }

 

  
}
