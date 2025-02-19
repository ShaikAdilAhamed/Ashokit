package in.ashokit.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.bindings.Address;
import in.ashokit.bindings.Passenger;

public class JavaToJson {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		Address address= new Address();
		address.setCity("Hyd");
		address.setState("TG");
		address.setCountry("India");
		
		Passenger passenger= new Passenger();
		passenger.setName("Raju");
		passenger.setFrom("Hyd");
		passenger.setTo("Delhi");
		passenger.setGender("Male");
		
		passenger.setAddress(address);
		
		//convert the java object to JSON we use Object mapper
		ObjectMapper mapper= new ObjectMapper();
		
		mapper.writeValue(new File("passenger.json"), passenger);
		System.out.println("Done");
	}
}
