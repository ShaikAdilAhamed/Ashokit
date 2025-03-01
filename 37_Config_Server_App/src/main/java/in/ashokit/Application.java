package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication


//The @EnableConfigServer annotation is used to enable the Config Server functionality
//in a Spring Boot application. It marks the application as a Spring Cloud Config Server
//that serves configuration properties to client applications. Once applied, the application
//can expose configuration files (e.g., .yml or .properties) from a centralized location, 
//which can then be consumed by client applications, enabling externalized configuration.
//This is part of the Spring Cloud Config module, which helps in managing configuration
//across multiple applications and environments in a centralized manner.

@EnableConfigServer
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
