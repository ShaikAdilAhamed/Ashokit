package in.ashokit.router;

import java.nio.channels.AcceptPendingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import in.ashokit.handler.GreetingHandler;

@Configuration
public class GreetRouter {

	//   GET ( /hello) ==> GreetingHadler :: handleGreet
	@Bean
	public RouterFunction<ServerResponse> route(GreetingHandler greetingHandler){
		return  RouterFunctions.route(GET("/hello")
				.and(accept(MediaType.APPLICATION_JSON)),greetingHandler::handleGreet);
	}
	
}
