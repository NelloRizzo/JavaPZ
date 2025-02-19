package corso.java.services;

import corso.java.data.Contact;

public class ContactService {
	private Contact[] contacts = new Contact[10];
	private int counter = 0;

	public void add(Contact c) {
		if (counter < 10) {
			contacts[counter] = c;
			counter++;
		}
		else {
			System.out.println("Rubrica completa");
		}
	}

	public void list() {
		System.out.println("Elenco contatti:");
		for (int i = 0; i < counter; ++i) {
			Contact c = contacts[i];
			System.out.printf("%s %s\t%s%n", c.getFirstName(), c.getLastName(), c.getPhoneNumber());
		}
	}
}
