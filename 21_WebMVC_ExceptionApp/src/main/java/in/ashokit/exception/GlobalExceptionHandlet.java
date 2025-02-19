package in.ashokit.exception;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandlet {
	 
    @ExceptionHandler(value = Exception.class)
    public ModelAndView handleGenericException(Exception ex) {
        ModelAndView view = new ModelAndView();
        view.setViewName("error");  
       
        return view;
    }
}
