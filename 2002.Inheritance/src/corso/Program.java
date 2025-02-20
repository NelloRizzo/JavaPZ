package corso;

import corso.java.Person;
import corso.java.Simple;
import corso.java.Vip;

public class Program {

	public static void mySystem(Person personToHandle) {
		System.out.println("Sistema di gestione di persone");
		System.out.println(personToHandle.describeMe());
		System.out.println("Fine elaborazione");
	}
	
	public static void main(String[] args) {
		Person p = new Person("Paperon", "De' Paperoni");
		System.out.println(p.getName());
		System.out.println(p.describeMe());

		Vip v = new Vip("Dott.", "Archimede", "Pitagorico");
//		v.setName("Archimede");
//		v.setSurname("Pitagorico");
		System.out.println(v.describeMe());
//		v.setTitle("Dott.");
		System.out.println(v.getTitle() + " " + v.getName());
		
		mySystem(p);
		mySystem(v);
		
		Simple s = new Simple();
		System.out.println(s.toString());
		System.out.println(s);
		
		System.out.println(p);
		System.out.println(v);
		
		Person p1 = new Person("Paperon", "De' Paperoni");
		
		if (p1.equals(p)) {
			System.out.println("Sono uguali");
		}
		else {
			System.out.println("Sono diversi");
		}
	}

}
