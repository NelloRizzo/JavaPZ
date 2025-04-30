package corso.java.tms.runners;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import corso.java.tms.entities.TickeState;
import corso.java.tms.services.TicketService;
import corso.java.tms.services.dto.ProcessingDto;
import corso.java.tms.services.dto.TicketDto;

@Component
public class TicketsTestRunner implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(TicketsTestRunner.class);
	private final TicketService service;

	public TicketsTestRunner(TicketService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) throws Exception {
		service.sendTicket(TicketDto.builder() //
				.withDescription("Ticket di esempio") //
				.withIssuedAt(LocalDateTime.now()) //
				.withState(TickeState.SENT) //
				.withSubject("Test") //
				.build()).ifPresentOrElse(t -> {
					logger.info("{}", t);
					var p = ProcessingDto.builder() //
							.withDate(LocalDateTime.now()) //
							.withDescription("Prima lavorazione") //
							.withResultState(TickeState.WORKING) //
							.build();
					t = service.workOn(t.getId(), p);
					logger.info("{}", t);
				}, () -> logger.error("Errore salvando il ticket"));
	}

}
