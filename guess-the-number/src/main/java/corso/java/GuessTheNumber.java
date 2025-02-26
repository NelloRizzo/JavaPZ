package corso.java;

import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

	// "PENSO" ad un numero compreso tra 1 e 1000.
	static int thinkANumber() {
		return new Random().nextInt(1000) + 1;
	}

	// Accetta un numero in input da tastiera.
	static int input() {
		System.out.print("A quale numero ho pensato? ");
		var s = new Scanner(System.in);
		return s.nextInt();
	}

	public static void main(String[] args) {
		// Il programma "pensa" ad un numero compreso
		// tra 1 e 1000.
		// L'utente ha a disposizione 10 tentativi per indovinarlo
		// sulla base dei suggerimenti che gli vengono proposti
		// ad ogni tentativo effettuato.
		// In particolare il programma comunica, se non è stato indovinato
		// il numero, se il numero digitato è più grande o più piccolo
		// del numero da indovinare.

	}

}
