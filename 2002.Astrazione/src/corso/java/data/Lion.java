package corso.java.data;

public class Lion extends Animal {

	public Lion() {
		super("Leone", "ruggisco");
	}

	@Override
	public void bark() {
		System.out.println("Roar");
	}


}
