package corso.java.tombola;

import java.util.Random;

public class NumbersBag {
	// i numeri nel sacchetto
	private int[] numbers = new int[90];
	// indice del prossimo numero da estrarre dal sacchetto
	private int counter = 0;
	
	// controlla se il sacchetto è vuoto
	public boolean isEmpty() {
		return counter == 90;
	}
	// costruzione del sacchetto
	public NumbersBag() {
		for (int i = 0; i < 90; ++i) {
			numbers[i] = i + 1;
		}
	}
	// mescolamento del sacchetto
	public void shuffle() {
		Random rnd = new Random();
		for(int times = 0; times < 1000; ++times) {
			int p1= rnd.nextInt(90);
			int p2 = rnd.nextInt(90);
			int temp = numbers[p2];
			numbers[p2] = numbers[p1];
			numbers[p1] = temp;
		}
	}
	// estrazione di un numero alla volta
	public int draw() {
		// un modo per comunicare che il sacchetto è vuoto
		if (isEmpty()) return -1; 
		// usando il sacchetto 
		// restituisce il prossimo numero estratto
		var number = numbers[counter];
		counter++;
		return number;
	}
}
