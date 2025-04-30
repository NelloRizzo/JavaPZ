package corso.java.tms.services.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseDto {
	private int id;
	private LocalDateTime createdAt;
}
