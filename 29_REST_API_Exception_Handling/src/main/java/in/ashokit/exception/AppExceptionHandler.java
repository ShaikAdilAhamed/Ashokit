package in.ashokit.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<ExceptionInfo>HandleCustomerNotFoundExeption(CustomerNotFoundException customerNotFoundException)
	{
		ExceptionInfo info=new ExceptionInfo();
		info.setCode("Ex0011");
		info.setMsg(customerNotFoundException.getMessage());
		info.setDate(LocalDateTime.now());
		
		return new ResponseEntity(info,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExceptionInfo>HandleCustomerNotFoundExeption(Exception ex)
	{
		ExceptionInfo info=new ExceptionInfo();
		info.setCode("Ex0022");
		info.setMsg(ex.getMessage());
		info.setDate(LocalDateTime.now());
		
		return new ResponseEntity(info,HttpStatus.BAD_REQUEST);
	}
}
