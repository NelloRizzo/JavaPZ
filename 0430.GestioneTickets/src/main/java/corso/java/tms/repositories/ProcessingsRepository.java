package corso.java.tms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import corso.java.tms.entities.TicketProcessingEntity;

public interface ProcessingsRepository extends JpaRepository<TicketProcessingEntity, Integer> {

}
