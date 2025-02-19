package in.ashokit.beans;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Main {

	public static void main(String[] args) {
		//1st way using bean factory (Deprecated  / going to remove in future)
		/*
		BeanFactory factory= new XmlBeanFactory(new ClassPathResource("Beans.xml"));
		System.out.println("Application execution finished");
		*/
		
		//2nd way
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		Car c=context.getBean(Car.class);
		c.drive();
		System.out.println("Application execution finished");

	}

}
