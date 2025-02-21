package corso.java;

import java.util.Random;

public class Program {
	public static void print(Alunno[] a) {
		for (var i = 0; i < a.length; ++i)
			System.out.println(a[i]);
	}

	public static void main(String[] args) {
		// Dati dei voti conseguiti da alunni, individuare
		// il voto massimo,
		// il voto minimo,
		// la media dei voti
		// e l'elenco degli alunni che hanno ottenuto un voto
		// più alto della media
		var rnd = new Random(1);
		var n = 10;
		var alunni = new Alunno[n];
		for (var i = 0; i < alunni.length; ++i) {
			alunni[i] = new Alunno( //
					String.format("Alunno %d", i + 1), //
					String.format("%04d", i + 1), //
					rnd.nextInt(3, 11) //
			);
		}
		System.out.println("Alunni:");
		print(alunni);
	}

}
