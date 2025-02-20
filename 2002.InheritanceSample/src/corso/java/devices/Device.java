package corso.java.devices;

public class Device {
	private String brand;
	private String model;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Device(String brand, String model) {
		this.brand = brand;
		this.model = model;
	}
	
	@Override
	public String toString() {
		return String.format("Device[brand=%s, model=%s]", brand, model);
	}
	
}
