package in.ashokit.util;

import com.google.gson.Gson;

import in.ashokit.bindings.Address;
import in.ashokit.bindings.Passenger;

public class JavaToJson {

	public static void main(String[] args)   {
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
      //ObjectMapper mapper= new ObjectMapper();
		
      //mapper.writeValue(new File("passenger.json"), passenger);
		Gson gson= new Gson();
		String json=gson.toJson(passenger);
		System.out.println(json);
		
		System.out.println("Done");
	}
}
