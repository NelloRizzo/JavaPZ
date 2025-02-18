package corso;

public class Program {

	public static void main(String[] args) {
		int n = 0;
		System.out.println("Ciclo While, n = " + n);
		while (n > 0) {
			System.out.println(n);
			n = n - 1;
		}
		n = 0;
		System.out.println("Ciclo Do/While, n = " + n);
		do {
			System.out.println(n);
			n = n - 1;
		} while (n > 0);

		int a = 0;
		a++;
		System.out.println("A = " + a);
		--a;
		System.out.println("A = " + a);

		System.out.println("A = " + a++);
		System.out.println("A = " + a);

		System.out.println("A = " + ++a);
		System.out.println("A = " + a);

		n = 10;
		while (--n > 0) {
			System.out.println(n);
		}
		System.out.println("For:");
		for (double x = 0, d = 0; x < 10; x++, d+=.1) {
			System.out.println(x + " " + d);
		}
	}

}
