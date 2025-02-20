package corso.java.data;

public class Singer extends Person implements InsertableInZoo {
	private String name;
	private String song;

	public Singer(String name, String song) {
		this.name = name;
		this.song = song;
	}

	@Override
	public String toString() {
		return String.format("%s canta %s", name, song);
	}

	@Override
	public void makeNoise() {
		System.out.println("Cantante " + name);
	}

	@Override
	public void bark() {
		System.out.println(song);
	}
}
