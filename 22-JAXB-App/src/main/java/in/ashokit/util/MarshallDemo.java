package in.ashokit.util;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import in.ashokit.binding.Address;
import in.ashokit.binding.Person;

public class MarshallDemo {

	public static void main(String[] args) throws JAXBException {
		
		Address address= new Address();
		address.setCity("HYD");
		address.setState("Telengana");
		address.setCountry("India");
		
		Person p= new Person();
		p.setId(101);
		p.setName("AshokIt");
		p.setGender("Male");
		p.setEmail("ashokitschool@gmail.com");
		p.setAddress(address);
		
		JAXBContext context = JAXBContext.newInstance(Person.class);
		
		Marshaller marshaller=context.createMarshaller();
		
		//create xml file (java objct data to xml file) external xml file
		marshaller.marshal(p, new File("person.xml"));
		
		System.out.println("done...........");
	}
}
