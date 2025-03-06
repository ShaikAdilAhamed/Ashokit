package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.CircuitBreakerService;

@RestController
public class CircuitBreakerController {

    @Autowired
    private CircuitBreakerService circuitBreakerService;

    @GetMapping("/data")
    public Integer callService() {
        return circuitBreakerService.callExternalService();
    
    }
}
