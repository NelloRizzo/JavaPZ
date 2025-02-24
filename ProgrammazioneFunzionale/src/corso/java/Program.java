package corso.java;

import java.time.LocalDate;

public class Program {

	static void sortAsc(int[] a) {
		for (var i = 0; i < a.length - 1; i++) {
			for (var j = i + 1; j < a.length; ++j) {
				if (a[i] > a[j]) {
					var temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	static void sortDesc(int[] a) {
		for (var i = 0; i < a.length - 1; i++) {
			for (var j = i + 1; j < a.length; ++j) {
				if (a[i] < a[j]) {
					var temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	static boolean testToSwap(int a, int b) {
		return a > b;
	}

	static void sortWithFunction(int[] a) {
		for (var i = 0; i < a.length - 1; i++) {
			for (var j = i + 1; j < a.length; ++j) {
				if (testToSwap(a[i], a[j])) {
					var temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	// Interfaccia funzionale
	interface Sorter {
		boolean testToSwap(int a, int b);
	}

	static class SwapClass implements Sorter {
		public boolean testToSwap(int a, int b) {
			return a > b;
		}
	}

	static class OtherSwap extends SwapClass {
		@Override
		public boolean testToSwap(int a, int b) {
			return a < b;
		}
	}

	static class StrangeOrder extends SwapClass {
		@Override
		public boolean testToSwap(int a, int b) {
			return a % 2 == 0 ? a > b : a < b;
		}
	}

	static void sort(int[] a, Sorter f) {
		for (var i = 0; i < a.length - 1; i++) {
			for (var j = i + 1; j < a.length; ++j) {
				if (f.testToSwap(a[i], a[j])) {
					var temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	static void print(int[] a) {
		for (int i = 0; i < a.length; ++i) {
			System.out.println(a[i]);
		}
	}

//	static void print(String[] a) {
//		for (int i = 0; i < a.length; ++i) {
//			System.out.println(a[i]);
//		}
//	}
//
//	static void print(LocalDate[] a) {
//		for (int i = 0; i < a.length; ++i) {
//			System.out.println(a[i]);
//		}
//	}

	static <T> void print(T[] a) {
		System.out.println("Stampa con tipo generico");
		for (int i = 0; i < a.length; ++i) {
			System.out.println(a[i]);
		}
	}

	static class Pair<F, S> {
		F first;
		S second;
	}

	public static void main1(String[] args) {
		int[] a = { 123, 543, 876, 213, 69, 84, 5, 90, 254690, 657, 234, 58, 456, 3, 15, 797 };
		System.out.println("Array da ordinare");
		print(a);
		sortAsc(a);
		System.out.println("Array ordinato");
		print(a);
		sortDesc(a);
		System.out.println("Array ordinato in senso decrescente");
		print(a);
		sortWithFunction(a);
		System.out.println("Array ordinato in senso decrescente con funzione esterna");
		print(a);
		sort(a, new SwapClass());
		System.out.println("Array ordinato in senso crescente con classe");
		print(a);
		sort(a, new OtherSwap());
		System.out.println("Array ordinato in senso decrescente con classe");
		print(a);
		sort(a, new StrangeOrder());
		System.out.println("Array ordinato in senso crescente con classe anonima");
		print(a);

		sort(a, new Sorter() { // implementazione di classe anonima

			@Override
			public boolean testToSwap(int a, int b) {
				return a > b;
			}
		});
		System.out.println("Array ordinato in senso crescente con lambda expressione");
		print(a);

//		sort(a, (int x, int y) -> {
//			return x > y;
//		});
		sort(a, (x, y) -> x > y);

	}

	public static void main(String[] args) {
		int[] a = { 132, 5432, 4537, 3467, 23544 };
		String[] s = { "Pippo", "Pluto", "Paperino" };
		LocalDate[] d = { LocalDate.now().plusDays(1), LocalDate.now(), LocalDate.now().plusDays(-1) };
		print(a);
		print(s);
		print(d);
		Object[] o = { 123, "Paperino", LocalDate.now() };
		print(o);
		var psd = new Pair<String, LocalDate>();
		psd.first = "Paperino";
		psd.second = LocalDate.now();
		var pds = new Pair<LocalDate, String>();
		pds.first = LocalDate.now();
		pds.second = "Paperino";
	}
}
