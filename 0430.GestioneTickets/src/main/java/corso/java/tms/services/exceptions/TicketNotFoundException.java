package corso.java.tms.services.exceptions;

public class TicketNotFoundException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public TicketNotFoundException() {
		super("Ticket not found", null);
	}

}
