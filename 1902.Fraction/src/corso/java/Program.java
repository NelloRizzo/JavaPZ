package corso.java;

import corso.java.fractions.Fraction;

public class Program {

	public static void main(String[] args) {
		Fraction f1 = new Fraction(10, -30);
		System.out.println(f1.asString());
		Fraction f2 = new Fraction(15, -1);
		System.out.println(f2.asString());
		System.out.println(f1.latex());

		Fraction f3 = new Fraction(-3, 3);
		Fraction r = f1.add(f3);
		System.out.println(r.asString());
		
		System.out.println(f1.mul(r).asString());
		
		System.out.println(new Fraction(-1.23).asString());
	}

}
