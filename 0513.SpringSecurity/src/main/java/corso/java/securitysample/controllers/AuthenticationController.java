package corso.java.securitysample.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import corso.java.securitysample.services.AuthenticationService;
import corso.java.securitysample.services.dto.AuthenticationRequestDto;
import corso.java.securitysample.services.dto.AuthenticationResponseDto;
import corso.java.securitysample.services.dto.RegisterRequestDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService authService;

	@PostMapping("register")
	public ResponseEntity<AuthenticationResponseDto> register(@RequestBody RegisterRequestDto dto) {
		return ResponseEntity.ok(authService.register(dto));
	}

	@PostMapping("register-all")
	public ResponseEntity<List<AuthenticationResponseDto>> registerAll(@RequestBody List<RegisterRequestDto> dto) {
		return ResponseEntity.ok(dto.stream().map(authService::register).toList());
	}

	@PostMapping("login")
	public ResponseEntity<AuthenticationResponseDto> login(@RequestBody AuthenticationRequestDto dto) {
		return ResponseEntity.ok(authService.authenticate(dto));
	}
}
