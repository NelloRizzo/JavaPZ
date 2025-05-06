package corso.java;

import java.util.ArrayList;
import java.util.List;

public class Switch {
	public enum Status {
		ON, OFF
	}

	public interface OnChange {
		void statusChanged(Status current);
	}

	private Status status;
	private String name;
	private final List<OnChange> devices = new ArrayList<>();

	public Switch(String name) {
		this.name = name;
		status = Status.OFF;
	}

	public Status getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

	public void press() {
		status = status == Status.ON ? Status.OFF : Status.ON;
		notifyStatusChanged();
	}

	public void linkDevice(OnChange device) {
		devices.add(device);
	}

	public void unlinkDevice(OnChange device) {
		devices.remove(device);
	}

	private void notifyStatusChanged() {
		devices.forEach(l -> l.statusChanged(status));
	}

	@Override
	public String toString() {
		return String.format("Interruttore %s è %s", name, status == Status.ON ? "acceso" : "spento");
	}

}
