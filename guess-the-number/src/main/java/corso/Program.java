package corso;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import corso.java.GuessTheNumber;
import corso.java.GuessTheNumberSolver;

public class Program {
	private static final Logger log = LoggerFactory.getLogger(Program.class);

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

	public static void main1(String[] args) {
		// Il programma "pensa" ad un numero compreso
		// tra 1 e 1000.
		// L'utente ha a disposizione 10 tentativi per indovinarlo
		// sulla base dei suggerimenti che gli vengono proposti
		// ad ogni tentativo effettuato.
		// In particolare il programma comunica, se non è stato indovinato
		// il numero, se il numero digitato è più grande o più piccolo
		// del numero da indovinare.
		int target = thinkANumber();
		System.out.println(target);
		int attempts = 10;
		boolean win = false;
		int min = 1;
		int max = 1000;
		while (attempts > 0 && !win) {
			System.out.printf("Tentativi a disposizione: %s - ", attempts);
			attempts--;
			var number = input();
			if (number < target) {
				System.out.println("Il numero inserito è minore del numero da indovinare");
				if (number > min)
					min = number;
			} else if (number > target) {
				System.out.println("Il numero inserito è maggiore del numero da indovinare");
				if (number < max)
					max = number;
			} else {
				win = true;
			}
			System.out.printf("Range di target: [%s-%s]%n", min, max);
		}
		if (win) {
			System.out.printf("Bravo, hai usato %s tentativi%n", 10 - attempts);
		} else {
			System.out.printf("Hai perso. Il numero da indovinare era %s%n", target);
		}
	}

	public static void main2(String[] args) {
		var game = new GuessTheNumber();
		while (!game.isWin() && !game.isLose()) {
			var number = input();
			switch (game.attempt(number)) {
			case LESS:
				System.out.println("Il numero da indovinare è più piccolo");
				break;
			case GREATER:
				System.out.println("Il numero da indovinare è più grande");
				break;
			default:
			}
		}
		if (game.isLose()) {
			System.out.printf("Hai perso, il numero era %s%n", game.getTarget());
		} else {
			System.out.printf("Hai vinto usando solo %s tentativi%n", 10 - game.getAttempts());
		}
	}

	public static void main(String[] args) {
		var solver = new GuessTheNumberSolver();
		for (int i = 0; i < 100; ++i) {
			var game = new GuessTheNumber();
			var result = solver.solve(game);
			log.info("{}", result);
		}
	}
}
