package corso.java.securitysample.services;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import corso.java.securitysample.entities.Role;
import corso.java.securitysample.entities.UserEntity;
import corso.java.securitysample.entities.UsersRepository;
import corso.java.securitysample.security.JwtService;
import corso.java.securitysample.security.SecurityUser;
import corso.java.securitysample.services.dto.AuthenticationRequestDto;
import corso.java.securitysample.services.dto.AuthenticationResponseDto;
import corso.java.securitysample.services.dto.RegisterRequestDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	private final UsersRepository repo;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationProvider authenticationManager;

	@Override
	public AuthenticationResponseDto register(RegisterRequestDto registerRequest) {
		var user = UserEntity.builder() //
				.withId(null) //
				.withPassword(passwordEncoder.encode(registerRequest.getPassword())) //
				.withRole(Role.USER) //
				.withUsername(registerRequest.getUsername()) //
				.build();
		repo.save(user);
		var token = jwtService.generateToken(Map.of(), new SecurityUser(user));
		return AuthenticationResponseDto.builder().withToken(token).build();
	}

	@Override
	public AuthenticationResponseDto authenticate(AuthenticationRequestDto authenticationRequest) {
		// tentiamo l'autenticazione
		authenticationManager.authenticate( //
				new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
						authenticationRequest.getPassword()));
		var user = repo.findByUsername(authenticationRequest.getUsername()).orElseThrow();
		var token = jwtService.generateToken(Map.of(), new SecurityUser(user));
		return AuthenticationResponseDto.builder().withToken(token).build();
	}
}
