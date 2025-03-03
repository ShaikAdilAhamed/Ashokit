package in.ashokit.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity // Enables method-level security using annotations like @PreAuthorize and @PostAuthorize
public class SecurityConfigurer {

    // DataSource will be autowired from the application.properties for the database connection
    @Autowired
    private DataSource dataSource;

    /**
     * This method configures the authentication manager to use JDBC authentication.
     * It connects to the database to verify credentials (username, password, and roles).
     */
    @Autowired
    public void authManager(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource) // Use the DataSource configured in application.properties
            .passwordEncoder(new BCryptPasswordEncoder()) // Use BCryptPasswordEncoder to hash and verify passwords
            .usersByUsernameQuery("select username, password, enabled from users where username=?") // SQL query to fetch user credentials
            .authoritiesByUsernameQuery("select username, authority from authorities where username=?"); // SQL query to fetch user roles/authorities
    }

    /**
     * This method configures HTTP security to specify which URLs can be accessed by which roles.
     */
    @Bean
    public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((req) -> req
                // "/admin" path requires the user to have the "ADMIN" role
                .requestMatchers("/admin").hasRole("ADMIN")
                
                // "/user" path can be accessed by both "ADMIN" and "USER" roles
                .requestMatchers("/user").hasAnyRole("ADMIN", "USER")
                
                // "/" path is publicly accessible (no authentication required)
                .requestMatchers("/").permitAll()
                
                // Any other request needs to be authenticated
                .anyRequest().authenticated()
            )
            // Enabling form-based login for authentication
            .formLogin();

        return http.build(); // Return the configured SecurityFilterChain
    }
}
