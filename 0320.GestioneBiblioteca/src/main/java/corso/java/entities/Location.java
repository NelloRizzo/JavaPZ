package corso.java.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
@Embeddable
public class Location {
	@Column(name = "location_room", length = 10)
	private String room;
	@Column(name = "location_shelf", length = 10)
	private String shelf;
	@Column(name = "location_row", length = 10)
	private String row;
	@Column(name = "location_index", length = 10)
	private String index;
}
