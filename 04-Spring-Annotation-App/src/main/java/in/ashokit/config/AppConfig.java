package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import in.ashokit.beans.Robot;

@Configuration    //To represent java class as configuration class
@ComponentScan (basePackages = {"in.ashokit","com.ibm"}) //scan for the beans available in the projects
//and basePackages = {"in.ashokit"} it will chweck with all package name who is starting from in.ashokit 
public class AppConfig {

	public AppConfig() {
		System.out.println("app config :: constructor");
	}

@Bean
public Robot buildRobot() {
		Robot r= new Robot();
		return r;
	}
	
}
