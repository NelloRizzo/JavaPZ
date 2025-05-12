package corso.java.elm.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true)
@SuperBuilder(setterPrefix = "with")
public class PackedSoftwareDto extends SoftwareDto {
	private final List<SoftwareDto> components = new ArrayList<>();
}
