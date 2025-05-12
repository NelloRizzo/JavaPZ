package corso.java.elm.dto;

import java.time.LocalDateTime;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(setterPrefix = "with")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseDto {
	@EqualsAndHashCode.Include
	private Integer id;
	private LocalDateTime createdAt;

	@PrePersist
	void prePersist() {
		id = null;
		createdAt = LocalDateTime.now();
	}
}
