package corso.java.devices;

public class Smartphone extends Device{

	private String os;
	
	public Smartphone(String brand, String model, String os) {
		super(brand, model);
		this.os = os;
	}

	@Override
	public String toString() {
		return String.format("Smartphone[os=%s, brand=%s, model=%s]", os, getBrand(), getModel());
	}

}
