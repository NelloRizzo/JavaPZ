package corso.java.securitysample.services.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(setterPrefix = "with")
public class AuthenticationResponseDto {
	private String username;
	private List<String> roles;
	private String token;
}
