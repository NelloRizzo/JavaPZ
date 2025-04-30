package corso.java.tms.services.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import corso.java.tms.entities.TickeState;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class TicketDto extends BaseDto {
	private LocalDateTime issuedAt;
	private String subject;
	private String description;
	private TickeState state;
	private final List<ProcessingDto> processing = new ArrayList<>();

	@Builder(setterPrefix = "with")
	public TicketDto(int id, LocalDateTime createdAt, LocalDateTime issuedAt, String subject, String description,
			TickeState state) {
		super(id, createdAt);
		this.issuedAt = issuedAt;
		this.subject = subject;
		this.description = description;
		this.state = state;
	}

}
