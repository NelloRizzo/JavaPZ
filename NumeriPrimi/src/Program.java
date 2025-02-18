
public class Program {

	public static void main(String[] args) {
		int number = 134512325;
		System.out.println("Numero = " + number);
		// devo controllare se esiste un numero tra 2 e "number" che sia divisore di
		// "number"

		// devo "contare" da 2 a number - 1!!!
		// faccio finta che il numero sia un numero primo e lo comunico alla macchina
		boolean isPrime = true;

		int counter = 2;
		while ((counter < number) && isPrime) { // || => OR ! NOT
			// ad ogni iterazione devo vedere se il valore attuale del contatore è divisore
			// di "number"
			int r = number % counter;
			// se trovo un divisore il numero non è primo
			if (r == 0) {
				isPrime = false;
				System.out.println("Il numero è divisibile per " + counter);
			}
			// altrimenti è primo
			counter++;
		}
		if (isPrime) {
			System.out.println("Il numero è primo");
		}
	}

}
