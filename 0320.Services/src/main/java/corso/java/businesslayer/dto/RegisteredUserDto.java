package corso.java.businesslayer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class RegisteredUserDto {
	private int id;
	private String email;
	private String givedName;
}
