
public class Program {

	public static void main1(String[] args) {
		int[] a = new int[10];
		for (int i = 0; i < 10; ++i) {
			a[i] = i * i;
		}

		for (int i = 0; i < 10; ++i) {
			System.out.println(a[i]);
		}

		int[] b = a;
		b[5] = 5000;

		for (int i = 0; i < 10; ++i) {
			System.out.println(a[i]);
		}
	}

	static void increment(int x) {
		System.out.println("Inizialmente x vale " + x);
		x++;
		System.out.println("Dopo l'incremento x vale " + x);
	}

	static void increment(int[] x) {
		System.out.println("Inizialmente x[0] vale " + x[0]);
		x[0]++;
		System.out.println("Dopo l'incremento x[0] vale " + x[0]);
	}

	static void print(int[] a) {
		System.out.println("Stampa dell'array di lunghezza " + a.length + ":");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 32, 56, 478, 8, 598, 435, 679, 5679, 3456 };
		int x = 1;

		System.out.println("Nel main x vale " + x);
		increment(x);
		System.out.println("Dopo la chiamata ad increment() x vale " + x);
		System.out.println("Nel main a[0] vale " + a[0]);
		increment(a);
		System.out.println("Dopo la chiamata ad increment() a[0] vale " + a[0]);
		print(a);
	}
}
