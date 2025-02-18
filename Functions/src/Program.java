
public class Program {
	// definizione di "METODO"
	static boolean isEven(int n) { // n è parametro del metodo
		// int n = 3;
		boolean result = true;
		//System.out.println("Test su " + n);
		if (n % 2 == 0) {
		//	System.out.println("Il numero è pari");
		} else {
		//	System.out.println("Il numero è dispari");
			result = false;
		}
		return result;
	}

	public static void main(String[] args) {
		// 16 è argomento del metodo
		boolean b = isEven(16); // -> richiama evenOrOdd e effettua l'operazione n=16
		if (b) {
			System.out.println("Il numero 16 è pari");
		} else {
			System.out.println("Il numero 16 è dispari");
		}
		
		if (!isEven(7)) {
			System.out.println("Il numero 7 è dispari");
		}
	}

}
