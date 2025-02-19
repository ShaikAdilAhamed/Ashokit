package in.ashokit.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;

@Service
public class MakeMyTripService {

	@Value("${irctc.endpoint.book.ticket}")
	private  String IRCTC_BOOK_TICKET_URL;
	
	@Value("${irctc.endpoint.get.ticket}")
    private  String IRCTC_GET_TICKET_URL;

//-------------------------------Rest Template (Web) --------------------------------------------------
	
	/*
	public Ticket processTicketBooking(Passenger passenger) {
       //Calling the api of other project in this project using RestTemplate
		RestTemplate restTemplate = new RestTemplate();
		// ( IRCTC_ENDPOINT_1) URL to hit
		// (passenger) Sending request body converted internally "class type to json" and send
		
		// (Ticket.class) Accepting response body that will converted internally from "json to class type " (Ticket.class)
                                       //  ( or )
		//(Ticket.class) If i need in "json" then i need to change here to String (IRCTC_ENDPOINT_1, passenger, String);
		
		
		ResponseEntity<Ticket> responseEntity = restTemplate.postForEntity(IRCTC_BOOK_TICKET_URL, passenger, Ticket.class);
		                                                   //(postForEntity) this is to send post request
		
		int statusCode = responseEntity.getStatusCodeValue();
		if (statusCode == 200) {
			// this will give me ticket object
			Ticket ticket = responseEntity.getBody();
			return ticket;
		}
		return null;
	}
	
	public Ticket getTicketInfo(String ticketId)
	{
		RestTemplate rt=new RestTemplate();
		
		// ( IRCTC_ENDPOINT_2) URL to hit
		// (ticketId) Sending ticketId 
		
		// (Ticket.class) Accepting response body that will converted internally from "json to class type " (Ticket.class)
		                                       //  ( or )
		//(Ticket.class) If i need in "json" then i need to change here to String (IRCTC_ENDPOINT_1, passenger, String);
				
				
		ResponseEntity<Ticket> responseEntity = rt.getForEntity(IRCTC_GET_TICKET_URL,Ticket.class,ticketId);
		                                         //getForEntity to send a get request
		
		 //.getStatusCodeValue() this will give the status code  of the api  ex: 200
		int statuscode=responseEntity.getStatusCodeValue();
		
		if(statuscode==200)
		{        // (.getBody()) this will give me ticket object
			Ticket ticket=responseEntity.getBody();
			return ticket;
		}
		return null;
		
	}
	*/
	//------------------------------Web client (Web Flux)----------------------------------------------------
	
	public Ticket getTicketInfo(String ticketId)
	{
		//sync request
		 WebClient webClient = WebClient.create(); //get WebClient Instance
		 Ticket ticket = webClient.get() //Represent HTTP GET Request
		          .uri(IRCTC_GET_TICKET_URL,ticketId) //END Point URL
		          .accept(MediaType.APPLICATION_JSON) //Response ACCEPT Only json value
		          .retrieve() //retrieve the response from ResponseBody of IRCTC_GET_TICKET_URL
		          .bodyToMono(Ticket.class)  //bind the responsebody to java object (ticket.class) 
		          .block(); //block() wait for the response (synchronized) //make sync call
		 
		 
		 if (ticket != null)
		 {
			 return ticket;
		 }
		
		return null;
	}
	
	public Ticket processTicketBooking(Passenger passenger) {
		//sync request
		 WebClient webClient = WebClient.create();//get WebClient Instance
		 Ticket ticket = webClient
				 .post() //Represtent HTTP POST Request
				 .uri(IRCTC_BOOK_TICKET_URL) //END Point URL
				 .body(BodyInserters.fromValue(passenger)) //request Body 
				 .header("Content-Type", "application/json")//setting header (accept in application/json)
				 .accept(MediaType.APPLICATION_JSON) //Response output ACCEPT Only json value
				 .retrieve()//retrieve the response from ResponseBody of IRCTC_BOOK_TICKET_URL
				 .bodyToMono(Ticket.class)  //bind the ResponseBody to java object (ticket.class) 
		         .block(); //block() wait for the response (synchronized) //make sync call
		 if (ticket != null)
		 {
			 return ticket;
		 }
		
		return null;
		}
}
