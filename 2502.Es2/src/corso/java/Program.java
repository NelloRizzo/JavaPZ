package corso.java;

import java.time.LocalDateTime;

import corso.java.entities.Action;
import corso.java.entities.Customer;
import corso.java.entities.Vehicle;
import corso.java.services.GarageService;
import corso.java.services.GarageServiceImpl;
import corso.java.services.exception.ServiceException;

public class Program {

	static void garage(GarageService service) {
		var v1 = new Vehicle("Fiat", "500L", "AA000AA", new Customer("Archimede", "0000000"));
		var v2 = new Vehicle("Hyunday", "Tucson", "AA001AA", new Customer("Archimede", "0000000"));
		var v3 = new Vehicle("Fiat", "Panda", "AA002AA", new Customer("Paperone", "0000000"));
		service.registerVehicle(v1);
		service.registerVehicle(v2);
		service.registerVehicle(v3);

		service.registerAction(new Action("Freni", LocalDateTime.now(), v1, 50));
		service.registerAction(new Action("Gomme", LocalDateTime.now(), v1, 450));
		service.registerAction(new Action("Olio", LocalDateTime.now(), v1, 70));
		service.registerAction(new Action("Freni", LocalDateTime.now(), v2, 50));
		service.registerAction(new Action("Motore", LocalDateTime.now(), v2, 950));

		service.returnVehicle(v1);
		try {
			service.registerAction(new Action("Freni", LocalDateTime.now(), v1, 50));
		} catch (ServiceException e) {
			System.out.println("Impossibile eseguire intervento");
		}

		service.getAllCustomers().forEach(System.out::println);
	}

	public static void main(String[] args) {
		// Un'autofficina ha la necessità di gestire
		// il parco macchine in riparazione.
		// Quando un cliente arriva, la macchina viene
		// registrata in un elenco.
		// Dopo la registrazione è possibile che
		// sulla macchina vengano effettuati diversi interventi.
		// Ogni intervento è caratterizzato da una descrizione
		// e un costo.
		// In ogni momento è possibile sapere il totale
		// degli interventi su ogni macchina e il costo complessivo.
		// Alla fine del lavoro la macchina viene rilasciata al
		// proprietario e quindi non sarà più possibile effettuare
		// interventi.
		garage(new GarageServiceImpl());
	}

}
