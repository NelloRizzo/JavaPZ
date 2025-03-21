package corso.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import corso.java.businesslayer.dto.RegisterUserDto;
import corso.java.businesslayer.services.UserService;

@Component
public class MainRunner implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(MainRunner.class);
	@Autowired
	UserService service;

	private void register(RegisterUserDto u) {

		var r = service.register(u);
		if (r == null) {
			log.info("Impossibile registrare l'utente");
		} else {
			log.info("{}", r);
		}
	}

	@Override
	public void run(String... args) throws Exception {
		var u = RegisterUserDto.builder() //
				.withConfirmation("password") //
				.withEmail("nellorizzo@live.it") //
				.withGivedName("Nello") //
				.withPassword("password").build();
		register(u);
		register(u);
		u.setConfirmation("");
		register(u);
	}

}
