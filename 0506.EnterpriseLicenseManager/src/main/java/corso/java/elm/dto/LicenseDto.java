package corso.java.elm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(setterPrefix = "with")
public class LicenseDto extends BaseDto {
	private String name;
	private SoftwareDto software;
	private int devices;
	private int users;
}
