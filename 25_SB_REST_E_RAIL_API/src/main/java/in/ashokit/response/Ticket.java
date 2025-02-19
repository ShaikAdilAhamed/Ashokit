package in.ashokit.response;

import lombok.Data;

@Data
public class Ticket {
	private Integer ticketid;
	private String from;
	private String to;
	private String trainNum;
	private String tktCost;
	private String ticketStatus;
}
