package corso.java.securitysample.services.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class RegisterRequestDto {
	private String password;
	private String username;
	@Builder.Default
	private List<String> roles = new ArrayList<>();
}
