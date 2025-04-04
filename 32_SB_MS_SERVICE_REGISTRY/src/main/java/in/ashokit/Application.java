package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //manually we need to register with eureka server
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
