package corso.java.securitysample.services;

import corso.java.securitysample.services.dto.AuthenticationRequestDto;
import corso.java.securitysample.services.dto.AuthenticationResponseDto;
import corso.java.securitysample.services.dto.AuthenticationSimpleResponseDto;
import corso.java.securitysample.services.dto.RegisterRequestDto;

public interface AuthenticationService {
	AuthenticationResponseDto register(RegisterRequestDto registerRequest);
	AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequest);
	AuthenticationSimpleResponseDto addUserToRole(String username, String roleName);
	AuthenticationSimpleResponseDto removeUserFromRole(String username, String roleName);
}
