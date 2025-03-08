package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import in.ashokit.models.AuthenticationRequest;
import in.ashokit.models.AuthenticationResponse;
import in.ashokit.security.MyUserDetailsService;
import in.ashokit.util.JwtUtil;

import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private MyUserDetailsService service;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<?> authentication(@RequestBody AuthenticationRequest request) {
        try {
            authManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("{\"error\": \"Invalid username or password\"}");
        }

        UserDetails userDetails = service.loadUserByUsername(request.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);

        AuthenticationResponse response = new AuthenticationResponse(jwt);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello World");
    }
}
