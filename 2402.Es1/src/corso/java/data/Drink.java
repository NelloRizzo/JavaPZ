package corso.java.data;

public class Drink extends MenuItem {
	private int ml;

	public Drink(String name, float price, int ml) {
		super(name, price);
		this.ml = ml;
	}

	public Drink(String name, float price) {
		super(name, price);
	}

	public int getMl() {
		return ml;
	}

	public void setMl(int ml) {
		this.ml = ml;
	}

	@Override
	public String toString() {
		return String.format("Drink(ml=%s, item=%s)", ml, super.toString());
	}

}
