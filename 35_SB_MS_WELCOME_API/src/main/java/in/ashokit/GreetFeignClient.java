package in.ashokit;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "GREET-API")//(Recommended)
//@FeignClient(name = "GREET-API", url = "http://localhost:9091")
public interface GreetFeignClient {

	@GetMapping("/greet")
	public String invokGreetApi();
	
	
	
}
