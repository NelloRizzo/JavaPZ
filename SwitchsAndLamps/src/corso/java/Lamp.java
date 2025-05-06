package corso.java;

import corso.java.Switch.OnChange;
import corso.java.Switch.Status;

public class Lamp implements OnChange {
	private String name;
	private boolean on;

	public Lamp(String name) {
		this.name = name;
		on = false;
	}

	public String getName() {
		return name;
	}

	public boolean isOn() {
		return on;
	}

	@Override
	public String toString() {
		return String.format("Lampadina %s è %s", name, on ? "accesa" : "spenta");
	}

	@Override
	public void statusChanged(Status current) {
		on = current == Status.ON;
	}
}
