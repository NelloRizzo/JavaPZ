package corso.java.data;

public abstract class Animal implements InsertableInZoo {
	private String kind;
	private String noise;

	public Animal(String kind, String noise) {
		super();
		this.kind = kind;
		this.noise = noise;
	}

	public void makeNoise() {
		System.out.println(this);
	}

	public abstract void bark();
	
	@Override
	public String toString() {
		return String.format("Sono un %s e %s...", kind, noise);
	}

}
