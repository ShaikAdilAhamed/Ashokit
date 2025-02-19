package in.ashokit.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Bean.xml");
		
		Motor m= context.getBean(Motor.class);
		
		m.doWork();
		
		ConfigurableApplicationContext cfg=(ConfigurableApplicationContext)context;
		cfg.registerShutdownHook();
		

	}

}
