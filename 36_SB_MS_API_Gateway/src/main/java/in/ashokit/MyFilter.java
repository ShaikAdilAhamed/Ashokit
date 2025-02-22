package in.ashokit;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;
import org.springframework.web.server.WebFilterChain;

@Component
public class MyFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // Get the request from the exchange
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        
        // Print out all the headers for debugging
        Set<String> keySet = headers.keySet();
        for (String key : keySet) {
            List<String> values = headers.get(key);
            System.out.println(key + " :: " + values);
        }

        // Check for a specific token in the headers (e.g., Authorization header)
//        String token = headers.getFirst("Authorization");
//        if (token == null || !token.startsWith("Bearer ")) {
//            // Log the error and reject the request
//            System.out.println("Invalid or missing token.");
//            // Respond with an error or perform other actions
//            // You can return an error response or proceed with a different logic
//            return Mono.error(new IllegalStateException("Token missing or invalid"));
//        }
        
        // If token is valid, continue with the filter chain
        return chain.filter(exchange);
    }
}
