package corso.java.data;

public class Dog extends Animal {

	private String name;

	public Dog(String name) {
		super("Cane", "abbaio");
		this.name = name;
	}

	public void bark() 
	{
		System.out.println("Bau");
	}
	@Override
	public String toString() {
		return super.toString() + " e mi chiamo " + name;
	}
}
