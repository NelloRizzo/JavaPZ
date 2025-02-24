package corso.java.data;

import java.util.Objects;

public abstract class MenuItem implements Comparable<MenuItem> {
	private String name;
	private float price;

	public MenuItem(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public MenuItem() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("MenuItem(name=%s, price=%s)", name, price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof MenuItem && hashCode() == obj.hashCode();
	}

	@Override
	public int compareTo(MenuItem o) {
		return getClass().getName().compareTo(o.getClass().getName());
	}

}
