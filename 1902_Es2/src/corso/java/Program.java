package corso.java;

import corso.java.data.Contact;
import corso.java.services.ContactService;

public class Program {

	public static void main(String[] args) {
		ContactService service = new ContactService();
		service.add(new Contact("Archimede", "Pitagorico", "3.1415926"));
		service.add(new Contact("Paperon", "De' Paperoni", "4444444444"));
		service.add(new Contact("Paolino", "Paperino", "1717171717"));
		service.add(new Contact("Gastone", "Paperone", "1313131313"));
		
		service.list();
	}

}
