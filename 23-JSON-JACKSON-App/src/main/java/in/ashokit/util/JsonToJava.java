package in.ashokit.util;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.bindings.Passenger;

public class JsonToJava {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		ObjectMapper mapper= new ObjectMapper();
		//passenger.json file data which contain json  to java object
		Passenger value = mapper.readValue(new File("passenger.json"), Passenger.class);
		System.out.println(value);

	}

}
