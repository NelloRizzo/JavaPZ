package corso.java.appcontext;

import corso.java.devices.Device;

public class DeviceService {
	// dispositivi gestiti
	private Device[] devices = new Device[10];
	// contatore dei dispositivi gestiti
	private int counter = 0;
	
	public void add(Device d) {
		if (counter < 10) {
			devices[counter] = d;
			counter++;
		}
		else
			System.out.println("Non posso gestire più di 10 dispositivi");
	}
	
	public void list(String brand) {
		// attraverso l'array dei dispositivi fino al numero di dispositivi gestito finora
		for(int i=0; i < counter; ++i) {
			// prendo il dispositivo i-esimo
			Device d = devices[i];
			// controllo che la marca sia quella richiesta nel parametro in input
			if (d.getBrand().equals(brand)) {
				// se è così, lo stampo richiamando il metodo toString()
				System.out.println(d);
			}
		}
	}
}
