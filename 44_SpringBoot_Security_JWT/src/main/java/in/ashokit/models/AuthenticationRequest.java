package in.ashokit.models;

import lombok.Data;

//To get the username and password from the client
@Data
public class AuthenticationRequest {
	private String username;
	private String password;

}
