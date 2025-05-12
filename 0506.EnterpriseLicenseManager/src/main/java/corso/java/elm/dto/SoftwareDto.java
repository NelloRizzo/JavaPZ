package corso.java.elm.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder(setterPrefix = "with")
public class SoftwareDto extends BaseDto {
	private String name;
	private LocalDate releasedAt;
	private String version;
	private String publisher;
}
