package corso.java;

import corso.java.data.Address;
import corso.java.data.Contact;
import corso.java.data.EmailAddress;
import corso.java.data.PhoneAddress;
import corso.java.data.PostalAddress;

public class Program {

	public static void main(String[] args) {
		Address[] paperAddresses = { new PostalAddress("via del Deposito", "44444", "Paperopoli", "PA", true),
				new EmailAddress("paperone@deposito.inc"), new EmailAddress("paperone@paperopoli.com"),
				new PhoneAddress("444444444") };
		Contact paperone = new Contact("Paperon", "De' Paperoni", "paperone", paperAddresses);
		System.out.println(paperone);

		Address[] archiAddresses = { new PostalAddress("via della Scienza", "3142", "Paperopoli", "PA"),
				new EmailAddress("archi@edi.org") };
		Contact archimede = new Contact("Archimede", "Pitagorico", "archi", archiAddresses);
		System.out.println(archimede);
	}

}
