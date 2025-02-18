package corso;

import java.util.Scanner;

public class Program {

	public static void main1(String[] args) {
		byte by = 10;  //byte = 8bit
		short sh = 15;  //2 byte
		// < > <= >= == !=
		if (by < 10) {
			int in = 234;  //4 byte
			long lo = 5335L;  //8 byte
		}
		double db = 123.45678; //8 byte - 15 cifre
		float fl = 123.45667F;  //4 byte - 7 cifre

		char ch = 'a';

		boolean bo = true;  //o false

		int expr = by + ((3 - sh) / 8) * 5;
		int m = 4 % 3;

		String s = "asdafgstrh";
		
		System.out.println(3 > 5);
		System.out.println(3 >= 5);
		System.out.println(3 <= 5);
		System.out.println(3 == 5);
		System.out.println(3 != 5);
	}

	public static void main(String[] args) {
		int anni = 19;
		if (anni < 18) {
			System.out.println("Sei minorenne");
		} else {
			System.out.println("Sei maggiorenne");
		}

		anni = 10;
		while (anni < 18) {
			System.out.println("Sei minorenne");
			anni = anni + 1;
		}
		System.out.println("Fine del programma");
	}
	
}
