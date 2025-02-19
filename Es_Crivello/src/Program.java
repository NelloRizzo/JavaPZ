
public class Program {

	static boolean[] sieve(int limit) {
		// creo l'array
		// (metto un elemento in più così posso cominciare a contare da 1)...
		boolean[] primes = new boolean[limit + 1];
		for (int i = 0; i <= limit; ++i)
			primes[i] = true; // all'inizio tutti i numeri sono primi
		// parto da 2
		for (int i = 2; i <= limit; ++i) {
			if (primes[i]) { // se l'elemento i-esimo è primo
				// i suoi multipli non lo saranno!!!
				for (int j = i + i; j <= limit; j = j + i) { // scorre i multipli di i
					// i multipli di i non sono primi
					primes[j] = false;
				}
			}
		}
		return primes;
	}

	public static void main(String[] args) {
		// https://it.wikipedia.org/wiki/Crivello_di_Eratostene
		boolean[] p = sieve(1000);
		for (int i = 2; i <= 1000; ++i) {
			if (p[i]) // se l'elemento in posizione i è true significa che i è primo!
				System.out.println(i);
		}
	}

}
