package in.ashokit.rest;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;

@RestController
public class ErailRestController {

	private Map<Integer, Ticket> tickets = new HashMap<>();

	@PostMapping(value = "/ticket", consumes = { "application/xml", "application/json" },
			                        produces = { "application/xml", "application/json" })
	public Ticket bookTicket(@RequestBody Passenger passenger) {
		// logic to book the ticket
		Ticket ticket = new Ticket();

		
		int ticketId = 100;

		ticket.setTicketid(ticketId);
		ticket.setFrom(passenger.getFrom());
		ticket.setTo(passenger.getTo());
		ticket.setTicketStatus("Confirmed");
		ticket.setTrainNum(passenger.getTrainNum());
		ticket.setTktCost("1500.00 INR");

		tickets.put(ticketId, ticket);
		
		ticketId++;

		return ticket;
	}

	 @GetMapping(value = "/ticket/{ticketId}", produces = { "application/xml", "application/json" })
	    public Ticket getTicket(@PathVariable("ticketId") Integer ticketId) {
	        System.out.println("Tickets Map: " + tickets);  
	        if (tickets.containsKey(ticketId)) {
	            return tickets.get(ticketId);
	        }
	        return null; 
	    }
}
