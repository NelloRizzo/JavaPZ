package corso.java;

public class Program {
	public static void main(String[] args) {

		var s1 = new Switch("Cucina");
		var s2 = new Switch("Corridoio");
		var l1 = new Lamp("Cucina 1");
		var l2 = new Lamp("Cucina 2");
		var l3 = new Lamp("Corridoio 1");

		s1.linkDevice(s -> System.out.printf("Interruttore %s: %s%n", s1.getName(), s));
		s2.linkDevice(s -> System.out.printf("Interruttore %s: %s%n", s2.getName(), s));

		s1.linkDevice(l1);
		s1.linkDevice(l2);
		s2.linkDevice(l3);

		s1.press();
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		s1.press();
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		s1.press();
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		
		s2.linkDevice(l1);
		var ml = new MultiLamp("ML", 10);
		s2.linkDevice(ml);
		s2.press();
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(ml);
		s2.unlinkDevice(l1);
		s2.press();
		System.out.println(l1);
		System.out.println(l2);
		System.out.println(l3);
		System.out.println(ml);
	}
}
