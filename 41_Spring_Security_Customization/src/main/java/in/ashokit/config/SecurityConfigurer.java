package in.ashokit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity //if i want to use roles for certain methods using this we can use two annotation " @PreAuthorize("hasRole('ADMIN')") and @PostAuthorize("hasRole('ADMIN')") "   in controller so that method can use by admin
public class SecurityConfigurer {
	
	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception
	{
	    http.authorizeHttpRequests((request) -> 
	        request
	            .requestMatchers("/", "/login-check", "/contact", "swagger-ui.html") // Public endpoints
	            .permitAll()
	            .anyRequest().authenticated() // All other endpoints require authentication
	    ).formLogin(); // Enables default (form-based) login for All other endpoints

	    return http.build();
	}


}
