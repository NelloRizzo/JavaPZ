package corso.java;

import java.util.Random;

public class Program {
	public static void print(Alunno[] a) {
		for (var i = 0; i < a.length; ++i)
			System.out.println(a[i]);
	}

	public static float avg(Alunno[] a) {
		float sum = 0;
		for (int i = 0; i < a.length; ++i) {
			sum += a[i].getVoto();
		}
		return sum / a.length;
	}

	public static Alunno[] bravi(Alunno[] a, float voto) {
		int counter = 0;
		for (var i = 0; i < a.length; ++i) {
			if (a[i].getVoto() >= voto) {
				counter++;
			}
		}
		var result = new Alunno[counter];
		var appoggio = 0;
		for (var i = 0; i < a.length; ++i) {
			if (a[i].getVoto() >= voto) {
				result[appoggio] = a[i];
				appoggio++;
			}
		}
		return result;
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
		float m = avg(alunni);
		System.out.printf("Media dei voti: %.2f%n", m);
		System.out.println("Alunno con voto superiore alla media");
		print(bravi(alunni, m));
	}

}
