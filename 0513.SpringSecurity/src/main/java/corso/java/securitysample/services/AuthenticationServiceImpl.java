package corso.java.securitysample.services;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import corso.java.securitysample.entities.RoleEntity;
import corso.java.securitysample.entities.UserEntity;
import corso.java.securitysample.repositories.RolesRepository;
import corso.java.securitysample.repositories.UsersRepository;
import corso.java.securitysample.security.JwtService;
import corso.java.securitysample.security.SecurityUser;
import corso.java.securitysample.services.dto.AuthenticationRequestDto;
import corso.java.securitysample.services.dto.AuthenticationResponseDto;
import corso.java.securitysample.services.dto.AuthenticationSimpleResponseDto;
import corso.java.securitysample.services.dto.RegisterRequestDto;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	private final UsersRepository repo;
	private final RolesRepository roles;
	private final JwtService jwtService;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationProvider authenticationManager;

	@Override
	public AuthenticationResponseDto register(RegisterRequestDto registerRequest) {
		var user = UserEntity.builder() //
				.withId(null) //
				.withPassword(passwordEncoder.encode(registerRequest.getPassword())) //
				.withUsername(registerRequest.getUsername()) //
				.build();
		repo.save(user);
		registerRequest.getRoles().forEach(r -> addUserToRole(user, r));
		var token = jwtService.generateToken(Map.of(), new SecurityUser(user));
		return AuthenticationResponseDto.builder() //
				.withUsername(user.getUsername()) //
				.withRoles(user.getRoles().stream().map(RoleEntity::getName).toList()) //
				.withToken(token) //
				.build();
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

	private void addUserToRole(UserEntity user, String roleName) {
		var role = roles.findByName(roleName).orElseGet(() -> {
			var r = RoleEntity.builder().withId(null).withName(roleName).build();
			return roles.save(r);
		});
		user.getRoles().add(role);
		repo.save(user);
	}

	@Override
	public AuthenticationSimpleResponseDto addUserToRole(String username, String roleName) {
		var user = repo.findByUsername(username).orElseThrow();
		addUserToRole(user, roleName);
		return new AuthenticationSimpleResponseDto(String.format("User %s added to role %s", username, roleName));
	}

	@Override
	public AuthenticationSimpleResponseDto removeUserFromRole(String username, String roleName) {
		var user = repo.findByUsername(username).orElseThrow();
		user.getRoles().removeIf(r -> r.getName().equals(roleName));
		repo.save(user);
		return new AuthenticationSimpleResponseDto(String.format("User %s removed from role %s", username, roleName));
	}
}
