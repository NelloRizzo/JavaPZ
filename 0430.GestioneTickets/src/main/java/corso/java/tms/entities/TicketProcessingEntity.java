package corso.java.tms.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor

@Entity
@Table(name = "processing")
public class TicketProcessingEntity extends BaseEntity {
	@Column(length = 1024, nullable = true)
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime date;
	@Enumerated(EnumType.ORDINAL)
	private TickeState resultState;
	@ToString.Exclude
	@ManyToOne(fetch = FetchType.EAGER)
	private TicketEntity ticket;

	@Builder(setterPrefix = "with")
	public TicketProcessingEntity(Integer id, LocalDateTime createdAt, String description, LocalDateTime date,
			TickeState resultState, TicketEntity ticket) {
		super(id, createdAt);
		this.description = description;
		this.date = date;
		this.resultState = resultState;
		this.ticket = ticket;
	}

}
