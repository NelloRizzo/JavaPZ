package corso.java;

public class Bucket {
	private int liters;
	private final int capacity;

	public Bucket(int capacity) {
		this.capacity = capacity;
		liters = 0;
	}

	public void full() {
		liters = capacity;
	}

	public void empty() {
		liters = 0;
	}

	public void transferInto(Bucket b) {
		// se this ha litri < free in b
		if (liters < b.freeSpace()) {
			// tutti i litri di this vanno in b
			liters = 0;
			b.setLiters(b.getLiters() + liters);
		}
		// altrimenti
		else {
			// ci vanno solo quelli che b può contenere
			liters -= b.freeSpace();
			b.full();
		}
	}

	public int getLiters() {
		return liters;
	}

	public int getCapacity() {
		return capacity;
	}

	public int freeSpace() {
		return capacity - liters;
	}

	public void setLiters(int liters) {
		this.liters = liters;
	}
}
