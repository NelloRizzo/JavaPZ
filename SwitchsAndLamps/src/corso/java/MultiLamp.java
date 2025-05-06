package corso.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import corso.java.Switch.OnChange;
import corso.java.Switch.Status;

public class MultiLamp implements OnChange {

	private final List<Lamp> lamps = new ArrayList<>();
	private final String name;

	public MultiLamp(String name, int total) {
		this.name = name;
		IntStream.range(1, total + 1).forEach(i -> lamps.add(new Lamp("Lamp-" + i)));
	}

	@Override
	public void statusChanged(Status current) {
		lamps.forEach(l -> l.statusChanged(current));
	}

	@Override
	public String toString() {
		return String.format("Multilamp[%s]-Lamps: %s", name, Arrays.toString(lamps.toArray()));
	}
}
