package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.ashokit.service.MakeMyTripService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		
		MakeMyTripService bean = context.getBean(MakeMyTripService.class);
	bean.getTicketInfoSync(100);
	//	bean.getTicketInfoAsync(100);
		
	}

}
