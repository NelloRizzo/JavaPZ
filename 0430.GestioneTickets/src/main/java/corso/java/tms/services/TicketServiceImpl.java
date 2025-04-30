package corso.java.tms.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import corso.java.tms.entities.TickeState;
import corso.java.tms.entities.TicketEntity;
import corso.java.tms.entities.TicketProcessingEntity;
import corso.java.tms.repositories.ProcessingsRepository;
import corso.java.tms.repositories.TicketsRepository;
import corso.java.tms.services.dto.ProcessingDto;
import corso.java.tms.services.dto.TicketDto;
import corso.java.tms.services.dto.mappings.ProcessingDtoEntityMapper;
import corso.java.tms.services.dto.mappings.ProcessingEntityDtoMapper;
import corso.java.tms.services.dto.mappings.TicketDtoEntityMapper;
import corso.java.tms.services.dto.mappings.TicketEntityDtoMapper;
import corso.java.tms.services.exceptions.ServiceException;
import corso.java.tms.services.exceptions.TicketNotFoundException;

@Service
public class TicketServiceImpl implements TicketService {
	private static final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

	private final TicketsRepository tickets;
	private final ProcessingsRepository processings;

	private final ProcessingEntityDtoMapper procE2D = p -> ProcessingDto.builder() //
			.withCreatedAt(p.getCreatedAt()) //
			.withDate(p.getDate()) //
			.withDescription(p.getDescription()) //
			.withId(p.getId()) //
			.withResultState(p.getResultState()) //
			.build();

	private final ProcessingDtoEntityMapper procD2E = p -> TicketProcessingEntity.builder() //
			.withCreatedAt(p.getCreatedAt()) //
			.withDate(p.getDate()) //
			.withDescription(p.getDescription()) //
			.withId(p.getId()) //
			.withResultState(p.getResultState()) //
			.build();

	private final TicketEntityDtoMapper ticketE2D = t -> {
		var ticket = TicketDto.builder() //
				.withCreatedAt(t.getCreatedAt()) //
				.withDescription(t.getDescription()) //
				.withId(t.getId()) //
				.withIssuedAt(t.getIssuedAt()) //
				.withState(t.getState()) //
				.withSubject(t.getSubject()) //
				.build();
		ticket.getProcessing().addAll(t.getProcessing().stream().map(procE2D::map).toList());
		return ticket;
	};

	private final TicketDtoEntityMapper ticketD2E = t -> TicketEntity.builder() //
			.withCreatedAt(t.getCreatedAt()) //
			.withDescription(t.getDescription()) //
			.withId(t.getId()) //
			.withIssuedAt(t.getIssuedAt()) //
			.withState(t.getState()) //
			.withSubject(t.getSubject()) //
			.build();

	public TicketServiceImpl(TicketsRepository tickets, ProcessingsRepository processings) {
		this.tickets = tickets;
		this.processings = processings;
	}

	@Override
	public Optional<TicketDto> sendTicket(TicketDto ticket) {
		try {
			var t = ticketD2E.map(ticket);
			t.setId(null);
			tickets.save(t);
			t.getProcessing();
			logger.info("{}", t);
			return Optional.of(ticketE2D.map(t));
		} catch (Exception e) {
			logger.error("Error sending ticket", e);
			return Optional.empty();
		}
	}

	@Override
	public List<TicketDto> getTickets(LocalDateTime from, LocalDateTime to) {
		try {
			return tickets.findAllByIssuedAtBetween(from, to).stream() //
					.map(ticketE2D::map).toList();
		} catch (Exception e) {
			logger.error("Error getting tickets", e);
			return List.of();
		}
	}

	@Override
	public List<TicketDto> getTicketsByState(LocalDateTime from, LocalDateTime to, TickeState... states) {
		try {
			return tickets.findAllByIssuedAtBetweenAndStateIn(from, to, states).stream() //
					.map(ticketE2D::map).toList();
		} catch (Exception e) {
			logger.error("Error getting tickets by state", e);
			return List.of();
		}
	}

	@Override
	public List<TicketDto> getAllTickets() {
		try {
			return tickets.findAll().stream() //
					.map(ticketE2D::map).toList();
		} catch (Exception e) {
			logger.error("Error getting all tickets", e);
			return List.of();
		}
	}

	@Override
	public TicketDto workOn(int ticketId, ProcessingDto processing) {
		try {
			var ticket = tickets.findById(ticketId).orElseThrow(TicketNotFoundException::new);
			var proc = procD2E.map(processing);
			proc.setTicket(ticket);
			proc.setId(null);
			processings.save(proc);
			if (ticket.getState() != proc.getResultState()) {
				ticket.setState(proc.getResultState());
			}
			ticket.getProcessing().add(proc);
			tickets.save(ticket);
			return ticketE2D.map(ticket);
		} catch (ServiceException e) {
			throw e;
		} catch (Exception e) {
			throw new ServiceException("Error adding process on tickets", e);
		}

	}

}
