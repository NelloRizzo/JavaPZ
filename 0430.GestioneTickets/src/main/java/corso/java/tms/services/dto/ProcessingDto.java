package corso.java.tms.services.dto;

import java.time.LocalDateTime;

import corso.java.tms.entities.TickeState;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ProcessingDto extends BaseDto {
	private String description;
	private LocalDateTime date;
	private TickeState resultState;

	@Builder(setterPrefix = "with")
	public ProcessingDto(int id, LocalDateTime createdAt, String description, LocalDateTime date,
			TickeState resultState) {
		super(id, createdAt);
		this.description = description;
		this.date = date;
		this.resultState = resultState;
	}

}
