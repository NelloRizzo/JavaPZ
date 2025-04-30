package corso.java.tms.repositories;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.tms.entities.TickeState;
import corso.java.tms.entities.TicketEntity;

public interface TicketsRepository extends JpaRepository<TicketEntity, Integer> {

	List<TicketEntity> findAllByIssuedAtBetween(LocalDateTime from, LocalDateTime to);

	List<TicketEntity> findAllByIssuedAtBetweenAndStateIn(LocalDateTime from, LocalDateTime to, TickeState[] states);

}
