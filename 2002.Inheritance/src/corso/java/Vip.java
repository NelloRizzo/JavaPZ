package corso.java;

public class Vip extends Person {
	private String title;

	public Vip(String title, String name, String surname) {
		super(name, surname);
		this.title = title;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String describeMe() {
		return String.format("Sono un vip con titolo di %s.", title) //
				//+ String.format("Mi chiamo %s %s", getName(), getSurname());
				+ super.describeMe();
	}
	
}
