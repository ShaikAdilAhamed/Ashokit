package in.ashokit.security;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		return new User("admin","$2a$12$gzFOoiw66ynVx3Tkyj.2TuOGfAXZJjqQpL9bqLo9Jf.s8irV1/.EG",new ArrayList<>());
	}

}
