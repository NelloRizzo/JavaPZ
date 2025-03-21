package corso.java.businesslayer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import corso.java.businesslayer.dto.LoginDto;
import corso.java.businesslayer.dto.LoginResponseDto;
import corso.java.businesslayer.dto.RegisterUserDto;
import corso.java.businesslayer.dto.RegisteredUserDto;
import corso.java.datalayer.entities.UserEntity;
import corso.java.datalayer.repositories.UsersRepository;

@Service
public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	UsersRepository users;

	@Override
	public RegisteredUserDto register(RegisterUserDto user) {
		try {
			if (user.getPassword().equals(user.getConfirmation())) {
				var u = users.save(UserEntity.builder() //
						.withEmail(user.getEmail()) //
						.withFriendlyName(user.getGivedName()) //
						.withPassword(user.getPassword()) //
						.build());
				return RegisteredUserDto.builder() //
						.withEmail(u.getEmail()) //
						.withGivedName(u.getFriendlyName()) //
						.withId(u.getId()) //
						.build();
			}
		} catch (Exception e) {
			log.error("Exception registering user", e);
		}
		return null;
	}

	@Override
	public LoginResponseDto login(LoginDto login) {
		// TODO Auto-generated method stub
		return null;
	}

}
