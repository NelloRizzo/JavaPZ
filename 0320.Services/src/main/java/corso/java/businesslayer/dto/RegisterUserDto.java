package corso.java.businesslayer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(setterPrefix = "with")
public class RegisterUserDto {
	private String email;
	private String password;
	private String confirmation;
	private String givedName;
}
