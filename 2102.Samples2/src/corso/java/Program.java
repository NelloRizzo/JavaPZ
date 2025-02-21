package corso.java;

import java.util.Random;

public class Program {

	static void print(int[] v, String[] n) {
		for (var i = 0; i < v.length; ++i) {
			System.out.printf("%s\t%d\n", n[i], v[i]);
		}
	}

	static int maxVote(int[] v) {
		int max = v[0];
		for (var i = 0; i < v.length; ++i) {
			if (v[i] > max)
				max = v[i];
		}
		return max;
	}

	static int count(int[] v, int voto) {
		var counter = 0;
		for (var i = 0; i < v.length; ++i) {
			if (v[i] == voto) {
				counter++;
			}
		}
		return counter;
	}

	public static void main(String[] args) {
		// Esistono 2 array nei quali sono memorizzati
		// i voti di n allievi e i nomi degli allievi
		// in maniera che a parità di indice si possa
		// recuperare il nome e il voto di ogni allievo
		var rnd = new Random(1);
		var voti = new int[10];
		var nomi = new String[10];
		for (var i = 0; i < voti.length; ++i) {
			voti[i] = rnd.nextInt(3, 10);
			nomi[i] = String.format("Alunnno %d", i + 1);
		}
		print(voti, nomi);
		var max = maxVote(voti);
		System.out.printf("Voto più alto: %d%n", max);
		var alunni = count(voti, max);
		System.out.printf("Alunni che hanno ottenuto %d: %d%n", max, alunni);
	}

}
