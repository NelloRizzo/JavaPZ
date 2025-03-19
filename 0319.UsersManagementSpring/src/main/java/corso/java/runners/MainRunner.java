package corso.java.runners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import corso.java.dao.PropertiesDao;
import corso.java.dao.RolesDao;
import corso.java.dao.UsersDao;
import corso.java.dao.UsersPropertiesDao;
import corso.java.dao.UsersRolesDao;
import corso.java.entities.Property;
import corso.java.entities.Role;
import corso.java.entities.User;
import corso.java.entities.UserProperty;
import corso.java.entities.UserRole;

@Component
public class MainRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(MainRunner.class);
	@Autowired
	private PropertiesDao properties;
	@Autowired
	private RolesDao roles;
	@Autowired
	private UsersDao users;
	@Autowired
	private UsersPropertiesDao userProperties;
	@Autowired
	private UsersRolesDao usersRoles;

	@Override
	public void run(String... args) throws Exception {
		// utenti
		var nello1 = User.builder() //
				.withFriendlyName("Nello") //
				.withPassword("password") //
				.withUsername("nellorizzo@live.it") //
				.build();
		var nello2 = User.builder() //
				.withFriendlyName("Nello Rizzo") //
				.withPassword("password") //
				.withUsername("nello.rizzo@libero.it") //
				.build();
		users.create(nello1);
		users.create(nello2);

		users.findAll().forEach(u -> log.info("{}", u));

		// ruoli
		var admin = Role.builder().withName("admin").build();
		var guest = Role.builder().withName("guest").build();

		roles.create(admin);
		roles.create(guest);
		roles.findAll().forEach(r -> log.info("{}", r));

		// recupero degli utenti tramite nome
		nello1 = users.findByUsername("nellorizzo@live.it").orElseThrow();
		nello2 = users.findByUsername("nello.rizzo@libero.it").orElseThrow();
		// recupero dei ruoli tramite nome
		admin = roles.findByName("admin").orElseThrow();
		guest = roles.findByName("guest").orElseThrow();

		// associazioni utenti-ruoli
		usersRoles.create(UserRole.builder().withRole(admin).withUser(nello1).build());
		usersRoles.create(UserRole.builder().withRole(admin).withUser(nello2).build());
		usersRoles.create(UserRole.builder().withRole(guest).withUser(nello2).build());
		usersRoles.findAllByRoleName("admin").forEach(ur -> log.info("{}", ur));
		usersRoles.findAllByUserUsername("nellorizzo@live.it").forEach(ur -> log.info("{}", ur));

		// proprietà
		var language = Property.builder().withName("language").build();
		var theme = Property.builder().withName("theme").build();
		properties.create(language);
		properties.create(theme);
		properties.findAll().forEach(p -> log.info("{}", p));

		// recupero di proprietà tramite nome
		language = properties.findByName("language").orElseThrow();
		theme = properties.findByName("theme").orElseThrow();

		// associazioni utente-proprietà
		userProperties.create(UserProperty.builder() //
				.withProperty(language) //
				.withUser(nello1) //
				.withValue("it") //
				.build());
		userProperties.create(UserProperty.builder() //
				.withProperty(language) //
				.withUser(nello2) //
				.withValue("en") //
				.build());
		userProperties.create(UserProperty.builder() //
				.withProperty(theme) //
				.withUser(nello1) //
				.withValue("light") //
				.build());
		// recupero di tutte le proprietà con l'elenco degli utenti
		// associati
		properties.findAll().forEach( //
				// per ogni proprietà legge le associazioni
				p -> userProperties.findAllByPropertyName(p.getName()) //
						.forEach(up -> log.info("{}", up)));
	}

}
