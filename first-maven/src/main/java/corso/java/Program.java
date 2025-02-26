package corso.java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Program {
	private static final Logger logger = LoggerFactory.getLogger(Program.class);

	public static void main(String[] args) {
		var p = new Person();
		p.setFirstName("Archimede");
		p.setSurname("Pitagorico");
		logger.info("Persona: {}!", p);

		var paperone = new Person("Paperon", "De' Paperoni");
		logger.info("{} <- Questo è paperone", paperone);

	}

}
