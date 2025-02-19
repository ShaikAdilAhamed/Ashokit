package in.ashokit.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service
public class MakeMyTripService {
	@Value("${irctc.endpoint.book.ticket}")
	private  String IRCTC_BOOK_TICKET_URL;
	
	@Value("${irctc.endpoint.get.ticket}")
    private  String IRCTC_GET_TICKET_URL;
	
	public void getTicketInfoSync(Integer ticketId)
	{
		System.out.println("Sync Method Execution started");
		
		WebClient client=WebClient.create();
		String response = client.get()
		       .uri(IRCTC_GET_TICKET_URL,ticketId)
		       .accept(MediaType.APPLICATION_JSON)
		       .retrieve()
		       .bodyToMono(String.class)
		       .block();  //wait for response
		
		System.out.println(response);
		//System.out.println("Sync - method ended.......");
		
		System.out.println("Sync Method Execution Ended");
	}
	
	public void getTicketInfoAsync(Integer ticketId)
	{
		System.out.println("ASYNC Method Execution started");
		WebClient client=WebClient.create();
				client.get()
				  .uri(IRCTC_GET_TICKET_URL,ticketId)
				  .accept(MediaType.APPLICATION_JSON)
				  .retrieve()
				  .bodyToMono(String.class)
				  .subscribe(response -> handleResponse(response));  //it will not wait for response //.subscribe() Asynchronous method
				  
			//	System.out.println("ASync - method ended.......");
				
				System.out.println("Async Method Execution Ended");
	}
	
	public void handleResponse(String response)
	{
		System.out.println(response);
	}
}
