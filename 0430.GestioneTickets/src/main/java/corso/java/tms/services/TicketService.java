package corso.java.tms.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import corso.java.tms.entities.TickeState;
import corso.java.tms.services.dto.ProcessingDto;
import corso.java.tms.services.dto.TicketDto;

public interface TicketService {
	Optional<TicketDto> sendTicket(TicketDto ticket);

	List<TicketDto> getTickets(LocalDateTime from, LocalDateTime to);

	List<TicketDto> getTicketsByState(LocalDateTime from, LocalDateTime to, TickeState... states);

	List<TicketDto> getAllTickets();

	TicketDto workOn(int ticketId, ProcessingDto processing);
}
