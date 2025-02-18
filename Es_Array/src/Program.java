
public class Program {

	static int min(int[] a) {
		// Come posso individuare il numero più piccolo tra tanti?
		// Facciamo finta che il numero più piccolo sia il primo
		int smaller = a[0];
		// poi scorro l'array
		for (int i = 0; i < a.length; i++) {
			// se un elemento è più piccolo di quello che ho trovato finora
			if (smaller > a[i]) {
				// allora questo elemento è il nuovo minimo
				smaller = a[i];
			}
		}
		// alla fine restituisco il minimo trovato
		return smaller;
	}

	static int sum(int[] a) {
		int sum =0;
		for(int i=0; i < a.length; ++i) {
			sum += a[i];
		}
		return sum;
	}

	static float avg(int a[]) {
		return 1.0f * sum(a) / a.length;
	}

	public static void main(String[] args) {
		// Dato l'array
		int[] a = { 432, 564, 478, 142, 589, 2346, 9, 60, 36572, 4253, 7, 9870 };
		// Individuare il numero più grande, il numero più piccolo,
		// la somma degli elementi e la media aritmetica
		int mi = min(a);
		System.out.println("Il valore minimo è: " + mi);
	}

}
