package in.ashokit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer  // @EnableAdminServer: Enables Spring Boot Admin server for monitoring and managing Spring Boot applications via a web-based UI.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
