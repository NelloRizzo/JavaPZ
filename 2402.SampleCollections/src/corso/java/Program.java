package corso.java;

import java.util.HashSet;
import java.util.Set;

import corso.java.data.Contact;
import corso.java.data.EmailDelivery;
import corso.java.data.PhoneDelivery;

public class Program {

	public static void main(String[] args) {
		// Una rubrica di contatti che possano gestire recapiti diversi
		Set<Contact> contacts = new HashSet<Contact>();
		contacts.add(new Contact("Paperino"));
		contacts.add(new Contact("Paperino"));

		var contact = new Contact("Archimede");
		contact.getDeliveries().add(new EmailDelivery("archi@lab.pp"));
		contact.getDeliveries().add(new PhoneDelivery("3141592"));
		contacts.add(contact);
		
		for(var c: contacts) {
			System.out.println(c);
		}
	}

}
