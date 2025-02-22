package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //it should identity and register  the eureka server so we will write this annotsation @EnableDiscoveryClient

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
