package in.ashokit.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.stereotype.Service;

@Service
public class CircuitBreakerService {

   

    @CircuitBreaker(name = "externalService", fallbackMethod = "fallbackMethod")
   
    public Integer callExternalService() {
        int generatedNumber = (int) (Math.random() * 10); 
        System.out.println("Generated number: " + generatedNumber);

        if (generatedNumber > 5) {
            throw new RuntimeException("Simulated service failure");
        }
        return generatedNumber;
    }

    // Fallback method
    public Integer fallbackMethod(Exception ex) {
        System.out.println("Fallback method invoked due to: " + ex.getMessage());
        return 0;
    }
}
