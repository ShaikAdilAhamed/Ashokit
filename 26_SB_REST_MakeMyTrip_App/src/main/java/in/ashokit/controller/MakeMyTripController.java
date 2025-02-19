package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ashokit.request.Passenger;
import in.ashokit.response.Ticket;
import in.ashokit.service.MakeMyTripService;

@Controller
public class MakeMyTripController {

	@Autowired
	private MakeMyTripService makeMyTripService;

	@GetMapping("/")
	private String index() {
		return "index";
	}

	@PostMapping("/bookTicket")
	// (Model) send data from controller to UI
	public String bookTicket(Passenger passenger, Model model) {
		Ticket ticketInfo = makeMyTripService.processTicketBooking(passenger);
		model.addAttribute("ticket", ticketInfo);
		System.out.println(passenger);
		return "success";
	}

	@GetMapping("/search")
	private String searchPage() {
		return "search";
	}

	@GetMapping("/searchTicket")
	                            
	private String searchTicket(@RequestParam("ticketId")  String ticketId,Model model) {
		System.out.println("ticket ID :: " + ticketId);
		Ticket ticketInfo = makeMyTripService.getTicketInfo(ticketId);
		System.out.println(ticketInfo);
		model.addAttribute("ticket",ticketInfo);
		//logic to get the ticket from irctc api
		return "search";
	}

}
