package corso.java.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class Contact {
	private String name;
	private Collection<Delivery> deliveries = new ArrayList<Delivery>();

	public Collection<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(Collection<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Contact(String name, Collection<Delivery> deliveries) {
		super();
		this.name = name;
		this.deliveries = deliveries;
	}

	public Contact(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Contact(name=%s, deliveries=%s)", name, deliveries);
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj instanceof Contact && hashCode() == obj.hashCode();
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
