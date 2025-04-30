package corso.java.tms.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
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
@Table(name = "tickets")
public class TicketEntity extends BaseEntity {
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime issuedAt;
	@Column(length = 80, nullable = false)
	private String subject;
	@Column(length = 1024, nullable = true)
	private String description;
	@Enumerated(EnumType.ORDINAL)
	private TickeState state;
	@OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private final List<TicketProcessingEntity> processing = new ArrayList<>();

	@Builder(setterPrefix = "with")
	public TicketEntity(Integer id, LocalDateTime createdAt, LocalDateTime issuedAt, String subject, String description,
			TickeState state) {
		super(id, createdAt);
		this.issuedAt = issuedAt;
		this.subject = subject;
		this.description = description;
		this.state = state;
	}

}
