package corso.java.businesslayer.services;

import corso.java.businesslayer.dto.LoginDto;
import corso.java.businesslayer.dto.LoginResponseDto;
import corso.java.businesslayer.dto.RegisterUserDto;
import corso.java.businesslayer.dto.RegisteredUserDto;

public interface UserService {
	RegisteredUserDto register(RegisterUserDto user);

	LoginResponseDto login(LoginDto login);
}
