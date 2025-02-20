package corso.java;

import corso.java.appcontext.DeviceService;
import corso.java.devices.Device;
import corso.java.devices.Smartphone;

public class Program {

	public static void main(String[] args) {
		DeviceService service = new DeviceService();
		service.add(new Device("Logitech", "Mouse"));
		service.add(new Device("Samsung", "Telecomando"));
		service.add(new Device("Samsung", "Smartphone"));
		service.add(new Smartphone("Samsung", "A71", "Android 9"));
		service.list("Samsung");
	}

}
