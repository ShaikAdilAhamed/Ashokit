package in.ashokit.beans;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class App {

	public static void main(String[] args) {
	ApplicationContext context= new ClassPathXmlApplicationContext("Beans.xml");
	
	Car c= context.getBean(Car.class);
	c.drive();

	}

}
