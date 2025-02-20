package corso.java;

import java.util.Objects;

public class Person extends Object {
	private String name;
	private String surname;

	public Person() {
	}

	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public String describeMe() {
		return String.format("Mi chiamo %s. %s", name.substring(0,1), surname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	@Override
	public boolean equals(Object obj) {
//		// controlla se obj è di tipo Person
//		if (obj instanceof Person) {
//			// (Person) converte obj in Person consentendoci di guardare alla Public view di Person
//			Person other = (Person)obj; // guarda obj come se fosse una persona!!!
//			if (other.name.equals(this.name) && other.surname.equals(this.surname))
//				return true;
//			else
//				return false;
//		}
//		return false;
		return obj instanceof Person && obj.hashCode() == this.hashCode();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, surname);
	}
	
	@Override
	public String toString() {
		return describeMe();
	}
}
