
public class Program {

	static String calcolatOre(int secondi) {
		// le ore sono: secondi / 3600
		int ore = secondi / 3600;
		// ovviamente trovate le ore i secondi da gestire sono di meno:
		// mi restano da gestire i secondi iniziali meno quelli trasformati in ore
		secondi = secondi - ore * 3600;
		// i minuti sono secondi / 60
		int minuti = secondi / 60;
		secondi = secondi - minuti * 60;
		String risultato = "" + ore + ":" + minuti + ":" + secondi;
		return risultato;
	}

	static int calcolatOre(String orario) {
		// dobbiamo individuare le diverse parti che compongono la stringa
		// calcoliamo dove si trova il primo carattere :
		int primo = orario.indexOf(':');
		// calcoliamo dove si trova l'ultimo carattere :
		int ultimo = orario.lastIndexOf(':');
		// prendiamo le tre parti della stringa
		String ore = orario.substring(0, primo);
		String minuti = orario.substring(primo + 1, ultimo);
		String secondi = orario.substring(ultimo + 1);

		int h = Integer.parseInt(ore);
		int m = Integer.parseInt(minuti);
		int s = Integer.parseInt(secondi);
		return h * 3600 + m * 60 + s;
	}

	public static void main(String[] args) {
		// Dato un tempo espresso in secondi, vogliamo una rappresentazione
		// dello stesso in ore:minuti:secondi
		System.out.println(calcolatOre(3671));

		// dato un orario nel formato ore:minuti:secondi, convertire tutto in secondi
		System.out.println(calcolatOre("1:1:11"));

		String[] parts = "1:1:11".split(":");
		for (int i = 0; i < parts.length; ++i) {
			System.out.println(parts[i]);
		}
		System.out.println( //
				Integer.parseInt(parts[0]) * 3600 //
						+ Integer.parseInt(parts[1]) * 60 //
						+ Integer.parseInt(parts[2]));
	}

}
