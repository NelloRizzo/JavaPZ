package corso.java.elm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(setterPrefix = "with")
@ToString(callSuper = true)
public class CompanyDto extends BaseDto {
	private String name;
	private String address;
	private String email;
	@EqualsAndHashCode.Include
	private String vat;
}
