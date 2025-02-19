package in.ashokit.util;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import in.ashokit.bindings.Passenger;

public class JsonToJava {

	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException  {
//		ObjectMapper mapper= new ObjectMapper();
//		//passenger.json file data which contain json  to java object
//		Passenger value = mapper.readValue(new File("passenger.json"), Passenger.class);
//		System.out.println(value);

		Gson gson= new Gson();
		Passenger p = gson.fromJson(new FileReader("passenger.json"), Passenger.class);
		System.out.println(p);
	}

}
